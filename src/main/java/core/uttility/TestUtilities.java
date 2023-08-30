package core.uttility;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;

public class TestUtilities {
    public static void assertStatusCodeAndErrorMessage(ValidatableResponse response, int expectedStatusCode) {
        response.assertThat().statusCode(expectedStatusCode);

        // Additional assertion for error message if status code is not as expected
        if (response.extract().statusCode() != expectedStatusCode) {
            String errorMessage = response.extract().asString();
            Assert.fail("Expected status code " + expectedStatusCode + " but got: " + response.extract().statusCode() + "\nError message: " + errorMessage);
        }
    }
}
