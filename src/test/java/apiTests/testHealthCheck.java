package apiTests;
import core.configuration.Configs;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HealthCheck;
public class testHealthCheck {
    private HealthCheck hc;
    @BeforeMethod
    public void initializePage() {
        hc = new HealthCheck();
    }
    @Test
    public void testHCheck() {
        String endpointURL = Configs.baseUrl;
        hc.healthCheck(endpointURL);
    }

}
