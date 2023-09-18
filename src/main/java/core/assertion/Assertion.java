package core.assertion;

import core.uttility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Assertion {
    private static BasePage basePage;
    public Assertion(BasePage basePage) {
        this.basePage = basePage;
    }
    public void assertSuccessMessageByLocator(By successMessageLocator, String expectedMessage, String error) {
        basePage.waitForVisibilityOfElement(successMessageLocator, 10);
        WebElement successMessage = basePage.findElement(successMessageLocator);
        String actualMessage = successMessage.getText();
        basePage.assertTextEquals(actualMessage, expectedMessage, error);
    }

    public String isElementPresent(By locator, String successMessage, String failureMessage) {
        if (basePage.isElementPresent(locator)) {
            Log.info("Element " + locator + " exists");
            return successMessage + ": " + basePage.findElement(locator).getTagName();
        } else {
            Log.info("Element " + locator + " not found");
            return failureMessage + ": " + locator.toString();
        }
    }
}
