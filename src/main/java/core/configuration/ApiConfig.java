package core.configuration;


public class ApiConfig {
    private static ConfigReader apiConfigReader = ConfigReader.getAPIInstance();

    public static String healthCheck() {
        return getString("healthCheck");
    }

    public static String baseURI() {
        return getString("baseURI");
    }

    // User controller
    public static String getAdminUser() {
        return getString("getAdminUser");
    }

    public static String getAllUser() {
        return getString("getAllUser");
    }

    public static String exportAllUsers() {
        return getString("exportAllUsers");
    }

    private static String getString(String key) {
        Object value = apiConfigReader.getAPIValue(key);
        if (value == null) {
            throw new IllegalArgumentException("Invalid API configuration key: " + key);
        }
        return value.toString();
    }


}
