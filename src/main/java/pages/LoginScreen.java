package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class LoginScreen {
    private WebDriver driver;

    private By userName = By.name("login");
    private By pass = By.name("password");
    private By loginButton = By.xpath("//button[contains(@class, 'bigButton__color-organish')]");

    public LoginScreen(WebDriver driver) {
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

    public void checkUserLogin(String username, String password) {
        enterUserName(username);
        enterUserPass(password);
        clickLoginButton();
        // Capture expected and actual values
        String expectedTitle = "Report Portal";
        String actualTitle = driver.getTitle();
        // assertion testNG to compare expected and actual values
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch");
    }


}
