package core.pageActions;

import core.configuration.UIConfig;
import core.uttility.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginPageActions extends LoginPage {

    public LoginPageActions(WebDriver driver) {
        super(driver);
    }

    @Step("Log in with {username} / {password}")
    public LoginPageActions userLogin(String username, String password) {
        enterUserName(username)
                .enterUserPass(password)
                .clickLoginButton();
        return this;
    }
    @Step("Log in with default user")
    public LoginPageActions defaultUserLogin() {
        String userName = UIConfig.getDefaultUserName();
        String userPass = UIConfig.getDefaultUserPass();
        enterUserName(userName)
                .enterUserPass(userPass)
                .clickLoginButton();
        return this;
    }
}
