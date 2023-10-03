package apiTests;

import core.configuration.PetsConfig;
import io.restassured.RestAssured;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BasePets {
    protected PetsConfig apiConfig;
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = PetsConfig.base();
        apiConfig = new PetsConfig();
    }

    @AfterTest
    public void tearDown() {
        RestAssured.reset();
    }

}
