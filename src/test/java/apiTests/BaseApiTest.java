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
        authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTUzNzkwODcsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiUmNERXUyTkJ6NFFGeWc3RGpZeE1DSlE0VHZvIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.Tu5C--SzRlx4jH9lH1l51hUJjMFoG63Tzl77vUc0EsI";
        apiConfig = new ApiConfig();
    }

    @AfterTest
    public void tearDown() {
        RestAssured.reset();
    }
}
