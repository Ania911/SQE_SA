package core.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Assertion {
    private static WebDriver driver;

    public Assertion(WebDriver driver) {
        this.driver = driver;
    }

    public void assertTitleEquals(String expectedTitle, String message) {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }

    public static void assertSuccessMessageByLocator( By successMessageLocator, String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        String actualMessage = successMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
