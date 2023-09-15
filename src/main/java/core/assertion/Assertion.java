package core.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    public static void assertSuccessMessageByLocator( By successMessageLocator, String expectedMessage, String error) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        String actualMessage = successMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, error);
    }

    public static String isElementPresent(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return "Element exists: " + element.getTagName();
        } catch (NoSuchElementException e) {
            return "Element not found: " + locator.toString();
        }
    }

}
