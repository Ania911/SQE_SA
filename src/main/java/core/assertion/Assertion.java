package core.assertion;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

public class Assertion {
    private BasePage basePage;

    public Assertion(BasePage basePage) {
        this.basePage = basePage;
    }
    public void assertElementPresent(By locator, String expected, String error) {
        String actual = basePage.getTextByLocator(locator);
        Assert.assertEquals(actual, expected, error);
    }

}
