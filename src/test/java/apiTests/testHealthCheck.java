package apiTests;
import core.uttility.TestUtilities;
import interfaces.api.healthCheck;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HealthCheck;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;

public class testHealthCheck {
    private HealthCheck hc;
    @BeforeMethod
    public void initializePage() {
        hc = new HealthCheck();
    }
    @Test
    public void testHCheck() {
        ValidatableResponse response = hc.healthCheck();
        TestUtilities.assertStatusCodeAndErrorMessage(response, 200);
    }

}
