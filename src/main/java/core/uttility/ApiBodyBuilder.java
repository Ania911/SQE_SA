package core.uttility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiBodyBuilder {

    private Long petId;

    private RequestSpecification createRequestSpec() {
        return given()
                .contentType(ContentType.JSON);
    }

    public String post(String endpoint, Object requestBodyObject) {
        RequestSpecification requestSpec = createRequestSpec();
        ObjectMapper objectMapper = new ObjectMapper();
        // Serialize the requestBodyObject to JSON
        String requestBodyJson;
        try {
            requestBodyJson = objectMapper.writeValueAsString(requestBodyObject);
        } catch (Exception e) {
            throw new RuntimeException("Error converting object to JSON: " + e.getMessage(), e);
        }
        requestSpec.body(requestBodyJson);
        Response response = requestSpec.when().post(endpoint);
        return response.getBody().asString();
    }

    public String postJson(String endpoint, String filePath, String newName, String status, List<String> photoUrls) {
        // Update and convert the object to JSON
        String requestBodyJson = PetJsonUtils.readAndUpdateToJson(filePath, petId, newName, status, photoUrls);

        // Send the POST request
        RequestSpecification requestSpec = createRequestSpec();
        requestSpec.body(requestBodyJson);
        Response response = requestSpec.when().post(endpoint);

        return response.getBody().asString();
    }

    public Long returnPetID(String endpoint, Object requestBodyObject) {
        RequestSpecification requestSpec = createRequestSpec();
        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize the requestBodyObject to JSON
        String requestBodyJson;
        try {
            requestBodyJson = objectMapper.writeValueAsString(requestBodyObject);
        } catch (Exception e) {
            throw new RuntimeException("Error converting object to JSON: " + e.getMessage(), e);
        }

        requestSpec.body(requestBodyJson);
        Response response = requestSpec.when().post(endpoint);

        // Extract the response ID
        petId = extractResponseId(response);
        return petId;
    }

    public String put(String endpoint, String filePath, Long petId, String newName, String status, List<String> photoUrls) {
        // Update and convert the object to JSON
        String requestBodyJson = PetJsonUtils.readAndUpdateToJson(filePath, petId, newName, status, photoUrls);

        // Send the PUT request
        RequestSpecification requestSpec = createRequestSpec();
        requestSpec.body(requestBodyJson);
        Response response = requestSpec.when().put(endpoint);

        return response.getBody().asString();
    }

    public Response delete(String endpoint) {
        RequestSpecification requestSpec = createRequestSpec();
        return requestSpec.when().delete(endpoint);
    }

    private Long extractResponseId(Response response) {
        String responseJson = response.getBody().asString();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseObject = objectMapper.readTree(responseJson);
            JsonNode idNode = responseObject.get("id");
            if (idNode != null && idNode.isNumber()) {
                return idNode.asLong();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
