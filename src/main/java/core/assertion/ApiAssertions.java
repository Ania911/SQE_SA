package core.assertion;

import io.restassured.response.Response;
import org.testng.Assert;
import org.json.JSONObject;

public class ApiAssertions {

    public static void assertStatusCodeEquals(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code does not match the expected value: " + expectedStatusCode);
    }

    public static void assertResponseBodyContains(Response response, String expectedString) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedString), "Response body does not contain the expected string: " + expectedString);
    }

    public static void assertJsonFieldInResponseBody(Response response, String fieldName, String expectedValue) {
        JSONObject responseBodyJson = new JSONObject(response.getBody().asString());
        Assert.assertEquals(responseBodyJson.getString(fieldName), expectedValue, "Value of field '" + fieldName + "' in response body does not match the expected value: " + expectedValue);
    }

}
