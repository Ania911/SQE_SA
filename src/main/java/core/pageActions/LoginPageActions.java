package core.pageActions;

import core.configuration.Configs;
import core.uttility.Log;
import org.apache.commons.lang.RandomStringUtils;
import pages.LoginPage;

public class LoginPageActions {
    private LoginPage loginPage;

    public LoginPageActions(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void userLogin(String username, String password) {
        Log.info("User log in to the app");
        loginPage.enterUserName(username);
        loginPage.enterUserPass(password);
        loginPage.clickLoginButton();
    }

    public void defaultUserLogin() {
        String userName = Configs.defaultUserName;
        String userPass = Configs.defaultUserPass;
        loginPage.enterUserName(userName);
        loginPage.enterUserPass(userPass);
        loginPage.clickLoginButton();
    }
}
