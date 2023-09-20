package core.uttility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiCaller {
    private String authToken;

    public ApiCaller(String authToken) {
        this.authToken = authToken;
    }

    public String get(String endpoint) {
        RequestSpecification requestSpec = createRequestSpec();
        Response response = requestSpec.when().get(endpoint);
        logResponse(response);
        return response.getBody().asString();
    }

    public Response post(String endpoint, Map<String, Object> requestBody) {
        RequestSpecification requestSpec = createRequestSpec();
        return requestSpec.body(requestBody).when().post(endpoint);
    }

    public Response put(String endpoint, Map<String, Object> requestBody) {
        RequestSpecification requestSpec = createRequestSpec();
        return requestSpec.body(requestBody).when().put(endpoint);
    }

    public Response delete(String endpoint) {
        RequestSpecification requestSpec = createRequestSpec();
        return requestSpec.when().delete(endpoint);
    }

    private RequestSpecification createRequestSpec() {
        return given()
                .header("Authorization", "Bearer " + authToken)
                .contentType(ContentType.JSON);
    }

    private void logResponse(Response response) {
        response.then().log().all();
    }
}
