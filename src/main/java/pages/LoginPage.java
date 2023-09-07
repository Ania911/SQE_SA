package pages;

import core.configuration.Configs;
import core.uttility.CommonActions;
import core.uttility.Log;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private CommonActions commonActions;
    private PageLocators locators;

//    private By userName = By.name("login");
//    private By pass = By.name("password");
//    private By loginButton = By.xpath("//button[contains(@class, 'bigButton__color-organish')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        locators = new PageLocators();
        commonActions = new CommonActions(driver);
        driver.get(Configs.loginPage);
    }

    public void enterUserName(String username) {
        commonActions.enterText(locators.userName, username);
//        wait
//        driver.findElement(userName).sendKeys(username);
    }
    public void enterUserPass(String password) {
        commonActions.enterText(locators.pass, password);
//        driver.findElement(pass).sendKeys(password);
    }

    public void clickLoginButton() {
        commonActions.clickButton(locators.loginButton);
//        driver.findElement(loginButton).click();
    }
//    Add new class

    public void userLogin(String username, String password) {
        Log.info("User log in to the app");
        enterUserName(username);
        enterUserPass(password);
        clickLoginButton();
//        // Capture expected and actual values
//        String expectedTitle = "Report Portal";
//        String actualTitle = driver.getTitle();
//        // Assertion testNG to compare expected and actual values
//        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
    }
}
