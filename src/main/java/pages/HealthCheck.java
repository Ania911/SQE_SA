package pages;
import interfaces.api.healthCheck;
import io.restassured.response.ValidatableResponse;
import core.configuration.Configs;
import static io.restassured.RestAssured.given;

public class HealthCheck implements healthCheck {

//   return response/body, separate class
    @Override
    public ValidatableResponse healthCheck() {
        return given()
                .when()
                .get(Configs.browser)
                .then().log().all()
                .statusCode(200);
    }
}
