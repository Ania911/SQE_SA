package core.uttility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ElementChecker {
    private WebDriver driver;

    public ElementChecker(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true; // Element found
        } catch (NoSuchElementException e) {
            return false; // Element not found
        }
    }

    public void checkElementAndReport(By locator, String errorMessage) {
        if (!isElementPresent(locator)) {
            throw new AssertionError(errorMessage);
        }
    }
}
