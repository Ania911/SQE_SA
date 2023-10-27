package pages;

import core.configuration.UIConfig;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private PageLocators locators;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(UIConfig.getLoginPage());
        locators = new PageLocators();
    }

    public LoginPage enterUserName(String username) {
        enterText(locators.userName, username);
        return this;
    }

    public LoginPage enterUserPass(String password) {
        enterText(locators.pass, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        clickButton(locators.loginButton);
        return this;
    }

}
