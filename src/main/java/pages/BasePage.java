package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<String> policyItems = new ArrayList<>();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public void clickButton(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void selectByValue(By locator, String value) {
        Select dropdownOptions = new Select(driver.findElement(locator));
        dropdownOptions.selectByValue(value);
    }

    private String getSelectedValue(By locator) {
        Select dropdownOptions = new Select(driver.findElement(locator));
        return dropdownOptions.getFirstSelectedOption().getText();
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

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement findElementWithWait(By locator) {
        waitForVisibilityOfElement(locator, 15);
        return findElement(locator);
    }

    public WebElement moveToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        return element;
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void getListItems(List<String> expectedPolicyItems, By locators) {
        List<WebElement> policyLinks = driver.findElements(locators);

        // Extract the text of the policy links and add them to the list
        for (WebElement link : policyLinks) {
            policyItems.add(link.getText());
        }

        // Compare the extracted policy items with the expected items
        for (String expectedItem : expectedPolicyItems) {
            if (!policyItems.contains(expectedItem)) {
                Assert.assertTrue(policyItems.contains(expectedItem), "Expected item not found: " + expectedItem);
            }
        }
    }

    public String getTextByLocator(By locator) {
        WebElement element = findElementWithWait(locator);
        String text = element.getText();
        System.out.println("The text is: " + text);
        return text;
    }

    public String getTextByAttribute(By locator) {
        WebElement element = findElementWithWait(locator);
        String text = element.getAttribute("alt");
        System.out.println("The text is: " + text);
        return text;
    }

    public String getTextByAttribute(By locator, String attribute) {
        WebElement element = findElementWithWait(locator);
        String text = element.getAttribute(attribute);
        System.out.println("The text is: " + text);
        return text;
    }

    public void waitForVisibilityOfElement(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return !elements.isEmpty();
    }

    public void selectRandomItem(By productGridLocator, By randomProductItem) {
        WebElement productGrid = driver.findElement(productGridLocator);
        WebElement randomProduct = getRandomProductItem(productGrid, randomProductItem);
        randomProduct.click();
    }

    private WebElement getRandomProductItem(WebElement productGrid, By locator) {
        List<WebElement> productItems = productGrid.findElements(locator);
        int randomIndex = (int) (Math.random() * productItems.size());
        return productItems.get(randomIndex);
    }


}
