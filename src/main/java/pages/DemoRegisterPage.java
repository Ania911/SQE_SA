package pages;

import core.configuration.UIConfig;
import locators.Locators;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class DemoRegisterPage extends BasePage {
    private Locators locators;

    public DemoRegisterPage(WebDriver driver) {
        super(driver);
        driver.get(UIConfig.getRegisterPage());
        locators = new Locators();
    }

    public DemoRegisterPage enterUserName(String userName) {
        enterText(locators.firstNameField, userName);
        return this;
    }

    public DemoRegisterPage enterLastName(String lastUserName) {
        enterText(locators.lastNameField, lastUserName);
        return this;
    }
    public DemoRegisterPage enterEmail() {
        String randomEmail = generateRandomEmail();
        enterText(locators.emailField, randomEmail);
        return this;
    }

    public DemoRegisterPage enterPass(String pass) {
        enterText(locators.passwordField, pass);
        return this;
    }
    public DemoRegisterPage confirmPassword(String pass) {
        enterText(locators.confirmPasswordField, pass);
        return this;
    }
    public DemoRegisterPage clickRegisterButton() {
        clickButton(locators.registerButton);
        return this;
    }

    public DemoRegisterPage enterUserEmail(String email) {
        enterText(locators.userEmail, email);
        return this;
    }
    public DemoRegisterPage enterUserPass(String pass) {
        enterText(locators.userPass, pass);
        return this;
    }
    public DemoRegisterPage clickLoginButton() {
        clickButton(locators.loginButton);
        return this;
    }

    private String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString();
        return "random" + uuid + "@example.com";
    }
}
