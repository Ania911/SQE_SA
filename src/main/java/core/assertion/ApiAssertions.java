package core.assertion;

import io.restassured.response.Response;
import org.testng.Assert;
import org.json.JSONObject;

import java.lang.reflect.Array;

public class ApiAssertions {

    public static void assertStatusCodeEquals(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code" + " does not match the expected value: " + expectedStatusCode);
    }

    public static void assertResponseBodyContains(Response response, String expectedString) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedString), "Response body does not contain the expected string: " + expectedString);
    }

    public static void assertJsonFieldInResponseBody(Response response, String fieldName, String expectedValue) {
        JSONObject responseBodyJson = new JSONObject(response.getBody().asString());
        Assert.assertEquals(responseBodyJson.getString(fieldName), expectedValue, "Value of field '" + fieldName + "' in response body does not match the expected value: " + expectedValue);
    }

//    private static void assertArrayEquals(Object actual, Object expected, String message) {
//        //is called only when expected is an array
//        if (actual.getClass().isArray()) {
//            int expectedLength = Array.getLength(expected);
//            if (expectedLength == Array.getLength(actual)) {
//                for (int i = 0 ; i < expectedLength ; i++) {
//                    Object _actual = Array.get(actual, i);
//                    Object _expected = Array.get(expected, i);
//                    try {
//                        assertEquals(_actual, _expected);
//                    } catch (AssertionError ae) {
//                        failNotEquals(actual, expected, message == null ? "" : message
//                                + " (values at index " + i + " are not the same)");
//                    }
//                }
//                //array values matched
//                return;
//            } else {
//                failNotEquals(Array.getLength(actual), expectedLength, message == null ? "" : message
//                        + " (Array lengths are not the same)");
//            }
//        }
//        failNotEquals(actual, expected, message);
//    }

}
