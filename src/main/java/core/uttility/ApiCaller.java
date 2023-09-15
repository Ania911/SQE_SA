package core.uttility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiCaller {

    public Response callEndpoint(String httpMethod, String endpoint, String authToken, Map<String, Object> requestBody) {
        Response response = null;

        // Configure the request using .given() and .header()
        RequestSpecification requestSpec = given()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON);

        switch (httpMethod.toUpperCase()) {
            case "GET":
                response = requestSpec.when().get(endpoint);
                break;
            case "POST":
                response = requestSpec.body(requestBody).when().post(endpoint);
                break;
            case "PUT":
                response = requestSpec.body(requestBody).when().put(endpoint);
                break;
            case "DELETE":
                response = requestSpec.when().delete(endpoint);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + httpMethod);
        }

        response.then().log().all();

        return response;
    }

}
