package core.configuration;

import java.util.Map;

public class AppConfig {
    private Map<String, Object> selenium;
    private Map<String, Object> restAssured;
    private Map<String, Object> environment;
    private Map<String, Object> other_settings;

    public Map<String, Object> getSelenium() {
        return selenium;
    }

    public Map<String, Object> getRestAssured() {
        return restAssured;
    }

    public Map<String, Object> getEnvironment() {
        return environment;
    }
}

