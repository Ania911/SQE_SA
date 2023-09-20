package core.assertion;

import org.testng.Assert;
import org.json.JSONObject;


public class ApiAssertions {

    public static void assertResponseCode(int actualStatusCode, int expectedStatusCode) {
        Assert.assertEquals(actualStatusCode, expectedStatusCode,
                "Expected status code: " + expectedStatusCode + ", but got: " + actualStatusCode);
    }

    public static void assertJsonField(String responseBody, String fieldName, String expectedValue) {
        JSONObject responseBodyJson = new JSONObject(responseBody);

        if (responseBodyJson.has(fieldName)) {
            String actualValue = responseBodyJson.getString(fieldName);
            Assert.assertEquals(actualValue, expectedValue, "Value of field '" + fieldName + "' in response body does not match the expected value: " + expectedValue);
        } else {
            Assert.fail("Field '" + fieldName + "' not found in response body");
        }
    }
}

