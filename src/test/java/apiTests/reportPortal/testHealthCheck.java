package apiTests.reportPortal;

import apiTests.BaseReportPortal;
import core.assertion.ApiAssertions;
import core.uttility.ApiMethods;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testHealthCheck extends BaseReportPortal {
    private ApiMethods apiMethod;

    @BeforeMethod
    public void initializePage() {
        apiMethod = new ApiMethods(authToken);
    }
    @Test
    public void testHCheck() {
        String url = apiConfig.healthCheck();
        String response = apiMethod.get(url);
        ApiAssertions.assertJsonField(response, "status", "UP");
    }
}
