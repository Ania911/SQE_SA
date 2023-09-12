package apiTests;

import core.configuration.ApiConfig;
import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseApiTest {
    protected String authToken;
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = ApiConfig.baseURI;;
        authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTQ1MTU4MDIsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiYVpHVklKeGlrQ0tmVVRnRFo5VE1Ma3BpTE8wIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.OqEqP0Xt8zy9Acank6S8zocqPS6wOQdGMJQk5gph6v4";
    }

    @AfterTest
    public void tearDown() {
        RestAssured.reset();
    }
}
