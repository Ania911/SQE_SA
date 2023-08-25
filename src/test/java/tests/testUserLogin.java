package tests;
import dataProvider.DP;
import org.testng.annotations.Test;
import utils.Log;

public class testUserLogin {

    @Test(dataProvider = "userLogin", dataProviderClass = DP.class)
    public void userLogin (String name, String pass) {
        Log.info("Testing logger");
        System.out.println("User Logins : " + name +" "+ pass);
    }
}
