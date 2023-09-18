package core.assertion;

import core.uttility.Log;
import locators.PageLocators;
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

    public static String isElementPresent(By locator, String successMessage, String failureMessage) {
        try {
            WebElement element = driver.findElement(locator);
            Log.info("Element" + locator + "exist");
            return successMessage + ": " + element.getTagName();
        } catch (NoSuchElementException e) {
            Log.info("Element" + locator + "not found");
            return failureMessage + ": " + locator.toString();
        }
    }
}
