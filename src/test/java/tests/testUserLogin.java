package tests;
import dataProvider.DP;
import org.testng.annotations.Test;

public class testUserLogin {

    @Test(dataProvider = "userLogin", dataProviderClass = DP.class)
    public void userLogin (String name, String pass) {
        System.out.println("User Logins : " + name +" "+ pass);
    }
}
