package core.pageActions;

import core.assertion.Assertion;
import core.configuration.Configs;
import core.uttility.Log;
import locators.PageLocators;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.LoginPage;

public class LoginPageActions extends LoginPage {

    public LoginPageActions(WebDriver driver) {
        super(driver);
    }

    public void userLogin(String username, String password) {
        Log.info("User log in to the app");
        enterUserName(username);
        enterUserPass(password);
        clickLoginButton();
    }

    public void defaultUserLogin() {
        String userName = Configs.getDefaultUserName();
        String userPass = Configs.getDefaultUserPass();
        enterUserName(userName);
        enterUserPass(userPass);
        clickLoginButton();
    }
}
