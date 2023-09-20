package core.configuration;

import core.uttility.Log;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigReader {

    private static ConfigReader uiInstance = null;
    private static ConfigReader apiInstance = null;

    private Map<String, Object> uiConfig;
    private Map<String, Object> apiConfig;

    private ConfigReader(String configFile) {
        loadConfig(configFile);
    }

    public static ConfigReader getUIInstance() {
        if (uiInstance == null) {
            uiInstance = new ConfigReader("config.yaml");
        }
        return uiInstance;
    }

    public static ConfigReader getAPIInstance() {
        if (apiInstance == null) {
            apiInstance = new ConfigReader("api-config.yaml");
        }
        return apiInstance;
    }

    private void loadConfig(String configFile) {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFile);
            if (inputStream != null) {
                if ("config.yaml".equals(configFile)) {
                    uiConfig = yaml.load(inputStream);
                    Log.info("UI Configuration loaded successfully");
                } else if ("api-config.yaml".equals(configFile)) {
                    apiConfig = yaml.load(inputStream);
                    Log.info("API Configuration loaded successfully");
                }
            } else {
                Log.error("Configuration file '" + configFile + "' not found");
            }
        } catch (Exception e) {
            Log.error("An error occurred while loading the configuration '" + configFile + "': " + e.getMessage());
        }
    }

    public Object getUIValue(String key) {
        return uiConfig.get(key);
    }

    public Object getAPIValue(String key) {
        return apiConfig.get(key);
    }
}
