package apiTests;

import core.assertion.ApiAssertions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testHealthCheck extends BaseApiTest {
    private ApiAssertions assertions;

    @BeforeMethod
    public void initializePage() {
        assertions = new ApiAssertions();
    }

    @Test
    public void testHCheck() {
        Response response = RestAssured.get();
        assertions.assertStatusCodeEquals(response, 200);
    }
}
