package core.configuration;

import java.util.Map;

public class Configs {
    private static final ConfigReader configReader = new ConfigReader("config.yml");
    private static final Map<String, Object> config = configReader.getConfig();

    // Access configuration values
    public static final String browser = getString("selenium.browser");
    public static final String baseUrl = getString("restAssured.baseURL");
    public static final String browserSize = getString("selenium.browserSize");
    public final static String loginPage = getString("environment.loginPage");
    public final static String defaultUserName = getString("defaultUser.username");
    public final static String defaultUserPass = getString("defaultUser.password");

    private static String getString(String key) {
        String[] keys = key.split("\\.");
        Map<String, Object> currentConfig = config;
        for (int i = 0; i < keys.length - 1; i++) {
            currentConfig = (Map<String, Object>) currentConfig.get(keys[i]);
            if (currentConfig == null) {
                throw new IllegalArgumentException("Invalid configuration key: " + key);
            }
        }
        Object value = currentConfig.get(keys[keys.length - 1]);
        if (value == null) {
            throw new IllegalArgumentException("Invalid configuration key: " + key);
        }
        return value.toString();
    }

    // Settings screen
    public final static String settingsPage = "http://localhost:8080/ui/#default_personal/settings/general";

    // Dashboard screen
    public final static String dashboardPage = "http://localhost:8080/ui/#default_personal/dashboard";

}