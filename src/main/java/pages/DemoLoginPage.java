package pages;

import core.configuration.UIConfig;
import locators.Locators;
import org.openqa.selenium.WebDriver;

public class DemoLoginPage extends BasePage {
    private Locators locators;

    public DemoLoginPage(WebDriver driver) {
        super(driver);
        driver.get(UIConfig.getUserLoginPage());
        locators = new Locators();
    }

    public DemoLoginPage enterUserEmail(String email) {
        enterText(locators.userEmail, email);
        return this;
    }

    public DemoLoginPage enterUserPass(String pass) {
        enterText(locators.userPass, pass);
        return this;
    }

    public DemoLoginPage clickLoginButton() {
        clickButton(locators.loginButton);
        return this;
    }

}
