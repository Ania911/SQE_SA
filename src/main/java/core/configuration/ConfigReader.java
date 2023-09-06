package core.configuration;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class ConfigReader {
    private Map<String, Object> config;

    public ConfigReader(String configFile) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configFile);
        config = yaml.load(inputStream);
    }

    public Map<String, Object> getConfig() {
        return config;
    }
}