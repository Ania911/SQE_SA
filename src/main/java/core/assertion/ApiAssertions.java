package core.assertion;

import org.testng.Assert;
import org.json.JSONObject;


public class ApiAssertions {

    public static void assertResponseCode(int actualStatusCode, int expectedStatusCode) {
        String errorMessage = String.format("Expected status code: %d, but got: %d", expectedStatusCode, actualStatusCode);
        Assert.assertEquals(actualStatusCode, expectedStatusCode, errorMessage);
    }


    public static void assertJsonField(String responseBody, String fieldName, String expectedValue) {
        JSONObject responseBodyJson = new JSONObject(responseBody);

        if (responseBodyJson.has(fieldName)) {
            String actualValue = responseBodyJson.getString(fieldName);
            String errorMessage = String.format("Value of field '%s' in response body does not match the expected value: '%s'", fieldName, expectedValue);
            Assert.assertEquals(actualValue, expectedValue, errorMessage);
        } else {
            String errorMessage = String.format("Field '%s' not found in response body", fieldName);
            Assert.fail(errorMessage);
        }
    }

    public static void assertJsonField(String responseBody, String fieldName, Boolean expectedValue) {
        JSONObject responseBodyJson = new JSONObject(responseBody);

        if (responseBodyJson.has(fieldName)) {
            boolean actualValue = responseBodyJson.getBoolean(fieldName);
            String errorMessage = String.format("Value of field '%s' in response body does not match the expected value: '%s'", fieldName, expectedValue);
            Assert.assertEquals(actualValue, expectedValue, errorMessage);
        } else {
            String errorMessage = String.format("Field '%s' not found in response body", fieldName);
            Assert.fail(errorMessage);
        }
    }
}

