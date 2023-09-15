package core.configuration;

import java.util.Map;

public class Configs {

    private static ConfigReader configReader = ConfigReader.getInstance();

    // Access configuration values
    public static String browser = getString("browser");
    public static String baseUrl = getString("envName");
    public static String browserSize = getString("browserSize");
    public static String defaultUserName = getString("username");
    public static String defaultUserPass = getString("password");
    public static String loginPage = getString("loginPage");
    public static String settingsPage = getString("settingsPage");
    public static String dashboardPage = getString("dashboardPage");

    private static String getString(String key) {
        Object value = configReader.getValue(key);
        if (value == null) {
            throw new IllegalArgumentException("Invalid configuration key: " + key);
        }
        System.out.println("Configuration key: " + key + ", Value: " + value);
        return value.toString();
    }


}