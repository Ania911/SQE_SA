package core.assertion;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

import java.io.File;

public class Assertion {
    private BasePage basePage;

    public Assertion(BasePage basePage) {
        this.basePage = basePage;
    }
    public void assertTextPresent(By locator, String expected, String error) {
        String actual = basePage.getTextByLocator(locator);
        Assert.assertEquals(actual, expected, error);
    }

    public void assertAttributePresent(By locator, String expected, String error) {
        String actual = basePage.getTextByAttribute(locator);
        Assert.assertEquals(actual, expected, error);
    }

    public void assertElementPresent(By locator, String error) {
        Boolean actual = basePage.isElementPresent(locator);
        Assert.assertTrue(actual, error);
    }

    public void assertDownloadedFile(File downloadedFile, String expectedFileName) {
        Assert.assertTrue(downloadedFile.exists(), "Downloaded file should exist");
        String actualFileName = downloadedFile.getName();
        Assert.assertEquals(actualFileName, expectedFileName, "File name does not match the expected file name");
    }


}
