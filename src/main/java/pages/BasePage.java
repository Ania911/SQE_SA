package pages;

import core.uttility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void clickButton(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void selectByValue(By locator, String options) {
        Select dropdownOptions = new Select(driver.findElement(locator));
        dropdownOptions.selectByValue(options);
    }

    public void selectByVisibleText(By locator, String options) {
        Select dropdownOptions = new Select(driver.findElement(locator));
        dropdownOptions.selectByVisibleText(options);
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementTextToContain(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public WebElement findElementWithWait(By locator) {
        waitForVisibilityOfElement(locator, 10);
        return findElement(locator);
    }

    public String getTextByLocator(By locator) {
        WebElement element = findElementWithWait(locator);
        String text = element.getText();
        System.out.println("The text is: " + text);
        return text;
    }

    public void waitForVisibilityOfElement(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }



}
