package pages;

import core.assertion.Assertion;
import core.configuration.Configs;
import core.pageActions.LoginPageActions;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private PageLocators locators;
    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(Configs.getLoginPage());
        locators = new PageLocators();
    }

    public void enterUserName(String username) {
        enterText(locators.userName, username);
    }
    public void enterUserPass(String password) {
        enterText(locators.pass, password);
    }
    public void clickLoginButton() {
        clickButton(locators.loginButton);
    }

}
