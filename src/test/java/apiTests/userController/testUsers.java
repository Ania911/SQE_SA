package apiTests.userController;

import apiTests.BaseApiTest;
import core.assertion.ApiAssertions;
import core.uttility.ApiCaller;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testUsers extends BaseApiTest {
    private ApiCaller apiMethod;

    @BeforeMethod
    public void initializePage() {
        apiMethod = new ApiCaller(authToken);
    }

    @Test
    public void testGetAdminUser() {
        String url = apiConfig.getAdminUser();
        String response = apiMethod.get(url);
        ApiAssertions.assertJsonField(response, "userId", "superadmin");
    }
}
