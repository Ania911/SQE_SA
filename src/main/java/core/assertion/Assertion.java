package core.assertion;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Assertion {
    private WebDriver driver;

    public Assertion(WebDriver driver) {
        this.driver = driver;
    }

    public void assertTitleEquals(String expectedTitle, String message) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, message);
    }

}
