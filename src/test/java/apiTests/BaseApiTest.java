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
        RestAssured.baseURI = ApiConfig.baseURI();;
        authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTUyMjIxNjQsInVzZXJfbmFtZSI6InN1cGVyYWRtaW4iLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOSVNUUkFUT1IiXSwianRpIjoiUXJuZmIwQk9lZkI4cTFxSDdlcGthWmlGaXlBIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.hqb_2roEy6f08cNotEhiquRSlUoPmwnf_MvEWclZU5Q";
        apiConfig = new ApiConfig();
    }

    @AfterTest
    public void tearDown() {
        RestAssured.reset();
    }
}
