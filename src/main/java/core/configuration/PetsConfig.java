package core.configuration;

public class PetsConfig {
    private static ConfigReader apiConfigReader = ConfigReader.getInstance("api-config.yaml");
    public static String base() {
        return getString("base");
    }
    public static String createUpdatePets() {
        return getString("createPets");
    }
    public static String deletePets() {
        return getString("deletePets");
    }

    private static String getString(String key) {
        Object value = apiConfigReader.getValue(key);
        if (value == null) {
            throw new IllegalArgumentException("Invalid configuration key: " + key);
        }
        return value.toString();
    }
}
