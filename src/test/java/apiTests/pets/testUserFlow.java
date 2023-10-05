package apiTests.pets;

import apiTests.BasePets;
import core.configuration.PetsConfig;
import core.dataProvider.DP;
import core.uttility.ApiBodyBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import petstore.CreateUser;

public class testUserFlow extends BasePets {

    private ApiBodyBuilder api;
    private CreateUser createUser;

    @BeforeMethod
    public void initializePage() {
        api = new ApiBodyBuilder();
        createUser = new CreateUser();
    }

    @Test(dataProvider = "petUser", dataProviderClass = DP.class)
    public void testAddNewPet(String username, String password) {
        createUser.setUser(username, password);
        String response = api.post(PetsConfig.createUser(), createUser);
        System.out.println(response);
//        ApiAssertions.assertJsonField(response, "username", username);
    }
}
