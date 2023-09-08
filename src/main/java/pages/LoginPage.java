package pages;

import core.configuration.Configs;
import core.uttility.CommonUIActions;
import core.uttility.Log;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private CommonUIActions commonActions;
    private PageLocators locators;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        locators = new PageLocators();
        commonActions = new CommonUIActions(driver);
        driver.get(Configs.loginPage);
    }

    public void enterUserName(String username) {
        commonActions.enterText(locators.userName, username);
    }
    public void enterUserPass(String password) {
        commonActions.enterText(locators.pass, password);
    }
    public void clickLoginButton() {
        commonActions.clickButton(locators.loginButton);
    }

}
