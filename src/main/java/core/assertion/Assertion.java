package core.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;

import java.io.File;
import java.util.List;

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

    public void assertSubGroups(List<WebElement> subGroups, int expectedSubGroupSize, String[] expectedGroupNames) {
        Assert.assertEquals(subGroups.size(), expectedSubGroupSize, "Expected " + expectedSubGroupSize + " sub-groups, but found " + subGroups.size());
        for (int i = 0; i < subGroups.size(); i++) {
            String actualGroupName = subGroups.get(i).getText();
            Assert.assertEquals(actualGroupName, expectedGroupNames[i], "Incorrect sub-group name at index " + i);
        }
    }
    public void assertCartHasItems(int cartQty) {
        Assert.assertTrue(cartQty > 0, "No items found in the shopping cart");
    }

}
