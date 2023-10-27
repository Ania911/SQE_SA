package apiTests.reportPortal;

import apiTests.BaseReportPortal;
import core.assertion.ApiAssertions;
import core.uttility.ApiMethods;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static core.uttility.RequestBodyBuilder.buildUserRequestBody;

public class testUsers extends BaseReportPortal {
    private ApiMethods apiMethod;

    @BeforeMethod
    public void initializePage() {
        apiMethod = new ApiMethods(authToken);
    }

    @Test
    public void testGetUserRegistration() {
        String url = apiConfig.getUserRegistration();
        String response = apiMethod.get(url);
        ApiAssertions.assertJsonField(response, "isActive", false);
    }

    @Test
    public void testCurrentLoggedInUser() {
        String url = apiConfig.getUser();
        String response = apiMethod.get(url);
        ApiAssertions.assertJsonField(response, "userId", "default");
    }

    @Test
    public void testCreateSpecifiedUser() {
        String url = apiConfig.getUser();
        Map<String, Object> requestBody = buildUserRequestBody("Testers12", "test1234");
        Integer response = apiMethod.post(url, requestBody);
        ApiAssertions.assertResponseCode(response, 403);
    }
}
