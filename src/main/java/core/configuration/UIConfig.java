package core.configuration;

public class UIConfig {

    private static ConfigReader configReader = ConfigReader.getUIInstance();

    // Access configuration values
    public static String getBrowser() {
        return getString("browser");
    }

    public static String getEnvName() {
        return getString("envName");
    }

    public static String getBrowserSize() {
        return getString("browserSize");
    }

    public static String getDefaultUserName() {
        return getString("username");
    }

    public static String getDefaultUserPass() {
        return getString("password");
    }

    public static String getLoginPage() {
        return getString("loginPage");
    }

    public static String getSettingsPage() {
        return getString("settingsPage");
    }

    public static String getDashboardPage() {
        return getString("dashboardPage");
    }

    private static String getString(String key) {
        Object value = configReader.getUIValue(key);
        if (value == null) {
            throw new IllegalArgumentException("Invalid configuration key: " + key);
        }
        return value.toString();
    }


}