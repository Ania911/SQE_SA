package apiTests.userController;

import apiTests.BaseApiTest;
import core.assertion.ApiAssertions;
import core.configuration.ApiConfig;
import core.uttility.ApiCaller;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testUsers  extends BaseApiTest {
    private ApiCaller apiCall;
    private ApiConfig apiConfig;
    private ApiAssertions assertions;


    @BeforeMethod
    public void initializePage() {
        apiCall = new ApiCaller();
        apiConfig = new ApiConfig();
        assertions = new ApiAssertions();
    }
    @Test
    public void testGetAdminUser() {
        String url = apiConfig.getAdminUser();
        Response response = apiCall.callEndpoint("GET", url, authToken, null);
        assertions.assertStatusCodeEquals(response, 200);
    }
}
