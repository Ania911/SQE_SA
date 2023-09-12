package core.assertion;

import io.restassured.response.Response;
import org.testng.Assert;

public class ApiAssertions {

        public static void assertStatusCodeEquals(Response response, int expectedStatusCode) {
            Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code does not match the expected value: " + expectedStatusCode);
        }

}
