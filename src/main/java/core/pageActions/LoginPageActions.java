package core.pageActions;

import core.configuration.UIConfig;
import core.uttility.Log;
import org.openqa.selenium.WebDriver;
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
        String userName = UIConfig.getDefaultUserName();
        String userPass = UIConfig.getDefaultUserPass();
        enterUserName(userName);
        enterUserPass(userPass);
        clickLoginButton();
    }
}
