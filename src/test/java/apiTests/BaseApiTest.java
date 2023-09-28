package apiTests;

import core.configuration.ApiConfig;
import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseApiTest {
    protected String authToken;
    protected ApiConfig apiConfig;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = ApiConfig.baseURI();
        authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTU3MzM3MjIsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoibDRGbUZOZHVIMllXQWJqNk51cnJtajJhNWpJIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.EOz31waULLts438T0b6Roc48tBNqDorefNUF2qCuIac";
        apiConfig = new ApiConfig();
    }

    @AfterTest
    public void tearDown() {
        RestAssured.reset();
    }
}
