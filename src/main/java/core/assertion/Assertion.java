package core.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
        WebElement successMessage = driver.findElement(successMessageLocator);
        String actualMessage = successMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
