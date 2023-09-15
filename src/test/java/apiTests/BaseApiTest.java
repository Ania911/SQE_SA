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
        authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTQ3Nzg3NDMsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiV1k1Z0NfVEttU3lQVUdQMWVOLUJ5SlRaN0lrIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.7S-5L170M1gikFnxPZwXHfdkmaJLG-Jtjq5IN8GmGQA";
    }

    @AfterTest
    public void tearDown() {
        RestAssured.reset();
    }
}
