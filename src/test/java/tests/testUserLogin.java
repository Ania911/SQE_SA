package tests;

import core.dataProvider.DP;
import core.uttility.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginScreen;

public class testUserLogin {
    private WebDriver driver;
    private WebDriverManager driverManager;
    private LoginScreen loginPage;

    @BeforeClass
    public void setUp() {
        driverManager = new WebDriverManager();
        driverManager.setUp();
        driver = driverManager.getDriver();
        driver.get("http://localhost:8080/ui/#login");
//        Initialize the loginPage object
        loginPage = new LoginScreen(driver);
    }

    @Test(dataProvider = "userData", dataProviderClass = DP.class)
    public void testSignIn(String username, String password) {
        loginPage.checkUserLogin(username,password);
    }

//    @Test(dataProvider = "userLogin", dataProviderClass = DP.class)
//    public void userLogin(String name, String pass) {
//        Log.info("Testing logger");
//        System.out.println("User Logins : " + name + " " + pass);
//    }
}
