package core.configuration;

import core.uttility.Log;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class BaseConfigReader {
    private static Map<String, Object> config;

    protected BaseConfigReader(String configFile) {
        loadConfig(configFile);
    }

    private void loadConfig(String configFile) {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFile);
            if (inputStream != null) {
                config = yaml.load(inputStream);
                Log.info("UI Configuration loaded successfully");
            } else {
                Log.error("Configuration file '" + configFile + "' not found");
            }
        } catch (Exception e) {
            Log.error("An error occurred while loading the configuration '" + configFile + "': " + e.getMessage());
        }
    }

    protected Object getValue(String key) {
        if (config != null) {
            return config.get(key);
        } else {
            return null;
        }
    }
}
