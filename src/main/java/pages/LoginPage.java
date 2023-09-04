package pages;

import core.uttility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    private By userName = By.name("login");
    private By pass = By.name("password");
    private By loginButton = By.xpath("//button[contains(@class, 'bigButton__color-organish')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void enterUserPass(String password) {
        driver.findElement(pass).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void userLogin(String username, String password) {
        Log.info("User log in to the app");
        enterUserName(username);
        enterUserPass(password);
        clickLoginButton();
        // Capture expected and actual values
        String expectedTitle = "Report Portal";
        String actualTitle = driver.getTitle();
        // Assertion testNG to compare expected and actual values
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
    }
}
