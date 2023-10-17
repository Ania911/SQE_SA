package apiTests.pets;

import apiTests.BasePets;
import core.assertion.ApiAssertions;
import core.configuration.PetsConfig;
import core.dataProvider.DP;
import core.uttility.ApiBodyBuilder;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import petstore.CreateUser;

import java.util.ArrayList;
import java.util.List;

public class testUsers extends BasePets {

    private ApiBodyBuilder api;
    private CreateUser createUser;

    @BeforeMethod
    public void initializePage() {
        api = new ApiBodyBuilder();
        createUser = new CreateUser();
    }

    @Test(dataProvider = "petUser", dataProviderClass = DP.class)
    public void testCreateUser(String username, String password) {
        createUser.setUser(username, password);
        Response response = api.generalPost(PetsConfig.createUser(), createUser);
        Integer statusCode = response.getStatusCode();
        ApiAssertions.assertResponseCode(statusCode, 200);
    }

    @Test(dataProvider = "petUser", dataProviderClass = DP.class)
    public void testCreateUserList(String username, String password) {
        List<CreateUser> userList = new ArrayList<>();
        createUser.addUsersToList(userList, username, password, 2);
        Response response = api.generalPost(PetsConfig.createUserList(), userList);
        Integer statusCode = response.getStatusCode();
        ApiAssertions.assertResponseCode(statusCode, 200);
    }

    @Test(dataProvider = "petUser", dataProviderClass = DP.class)
    public void testUserLogin(String username, String password) {
        String baseUrl = PetsConfig.loginUser();
        String url = baseUrl + username + "&password=" + password;
        String response = api.get(url);
        ApiAssertions.assertJsonField(response, "code", 200);
    }

    @Test
    public void testUserLogout() {
        String response = api.get(PetsConfig.logoutUser());
        ApiAssertions.assertJsonField(response, "message", "ok");
    }
}