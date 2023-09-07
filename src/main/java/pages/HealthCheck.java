package pages;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import core.configuration.Configs;
import static io.restassured.RestAssured.given;

public class HealthCheck {
    public static Response response;
    public static String jsonAsString;

    public ValidatableResponse healthCheck(String endpointURL) {
        ValidatableResponse response = given()
                .when()
                .get(endpointURL)
                .then().log().all();
        return response;
    }

    public String extractResponse(String endpoint) {
        response =
                given()
                        .when()
                        .get(endpoint)
                        .then().extract().response();
        return jsonAsString = response.asString();
    }

}
