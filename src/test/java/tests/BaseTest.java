package tests;

import core.uttility.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected org.openqa.selenium.WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        WebDriver driverManager = new WebDriver();
        driverManager.setUp();
        driver = driverManager.getDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}