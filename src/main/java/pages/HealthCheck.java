package pages;
import interfaces.api.healthCheck;
import io.restassured.response.ValidatableResponse;
import core.configuration.Configs;
import static io.restassured.RestAssured.given;

public class HealthCheck implements healthCheck {

    @Override
    public ValidatableResponse healthCheck() {
        return given()
                .when()
                .get(Configs.healthCheck)
                .then().log().all()
                .statusCode(200);
    }
}
