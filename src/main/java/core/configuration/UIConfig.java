package core.configuration;

public class UIConfig {
    private static ConfigReader configReader = ConfigReader.getInstance("config.yaml");

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

    public static String getChromeOptions() {
        return getString("chromeOptions");
    }

    public static String getFirefoxOptions() {
        return getString("firefoxOptions");
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

    public static String getMainPage() {
        return getString("mainPage");
    }

    public static String getResearchPage() {
        return getString("researchPage");
    }

    public static String getUrlLink() {
        return getString("urlLink");
    }

    public static String getSettingsPage() {
        return getString("settingsPage");
    }

    public static String getDashboardPage() {
        return getString("dashboardPage");
    }

    //     demoWebShop
    public static String getRegisterPage() {
        return getString("registerPage");
    }

    public static String getUserLoginPage() {
        return getString("userLoginPage");
    }

    public static String getComputerPage() {
        return getString("computerPage");
    }

    public static String getDesktopPage() {
        return getString("desktopPage");
    }

    private static String getString(String key) {
        Object value = configReader.getValue(key);
        if (value == null) {
            throw new IllegalArgumentException("Invalid configuration key: " + key);
        }
        return value.toString();
    }


}