package apiTests;

import core.configuration.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import static core.uttility.RequestBodyBuilder.buildTokenRequestBody;
import static io.restassured.RestAssured.given;

public class BaseReportPortal {
    protected String authToken;
    protected ApiConfig apiConfig;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = ApiConfig.baseURI();
        authToken = obtainAuthToken(ApiConfig.user(), ApiConfig.pass());
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
