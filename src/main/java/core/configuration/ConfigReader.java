package core.configuration;

public class ConfigReader extends BaseConfigReader {
    private static ConfigReader instance = null;

    // Private constructor to prevent external instantiation
    private ConfigReader(String configFile) {
        super(configFile);
    }

    public static ConfigReader getInstance(String configName) {
        if (instance == null) {
            instance = new ConfigReader(configName);
        }
        return instance;
    }
}
