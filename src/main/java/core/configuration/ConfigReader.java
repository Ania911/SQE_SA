package core.configuration;

import core.uttility.Log;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigReader {

    private static ConfigReader instance = null;
    private Map<String, Object> config;

    private ConfigReader() {
        loadConfig();
    }

    public static ConfigReader getInstance() {
        if (instance == null) {
            instance = new ConfigReader();
        }
        return instance;
    }

    private void loadConfig() {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.yaml");
            if (inputStream != null) {
                config = yaml.load(inputStream);
                Log.info("Configuration loaded successfully");
            } else {
                Log.error("Configuration file 'config.yaml' not found");
            }
        } catch (Exception e) {
            Log.error("An error occurred while loading the configuration: " + e.getMessage());
        }
    }

    public Object getValue(String key) {
        return config.get(key);
    }

}