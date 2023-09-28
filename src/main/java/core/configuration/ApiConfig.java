package core.configuration;


public class ApiConfig {
    private static ConfigReader apiConfigReader = ConfigReader.getInstance("api-config.yaml");
    public static String token() {
        return getString("token");
    }

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

    public static String getUser() {
        return getString("getUser");
    }

    public static String exportAllUsers() {
        return getString("exportAllUsers");
    }

    private static String getString(String key) {
        Object value = apiConfigReader.getValue(key);
        if (value == null) {
            throw new IllegalArgumentException("Invalid configuration key: " + key);
        }
        return value.toString();
    }


}
