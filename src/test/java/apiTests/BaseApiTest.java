package apiTests;

import core.configuration.ApiConfig;
import core.uttility.RequestBodyBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import static core.uttility.RequestBodyBuilder.buildTokenRequestBody;
import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected String authToken;
    protected ApiConfig apiConfig;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = ApiConfig.baseURI();
//        authToken = obtainAuthToken(ApiConfig.user(), ApiConfig.pass());
        authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTYwNjY5NzksInVzZXJfbmFtZSI6ImRlZmF1bHQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoidExjeHIzLXkxUGdYNnk3cUJhaHk1UEhoZjZzIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.ZZKbmZRn4f9xN-LQpOu1dUA8CMOs-CmbNN6OVGo_6CE";
        apiConfig = new ApiConfig();
    }

    public String obtainAuthToken(String username, String password) {
        Map<String, Object> requestBody = buildTokenRequestBody(username, password);
        Response response = given()
                .body(requestBody)
                .post(ApiConfig.token());

        return response.then()
                .statusCode(200)
                .extract()
                .path("access_token");
    }


    @AfterTest
    public void tearDown() {
        RestAssured.reset();
    }
}
