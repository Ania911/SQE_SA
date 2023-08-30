package interfaces.api;

import io.restassured.response.ValidatableResponse;

public interface healthCheck {
    public ValidatableResponse healthCheck();
}
