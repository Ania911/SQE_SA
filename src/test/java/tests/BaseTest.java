package tests;

import core.uttility.WebDriverManager;
import org.openqa.selenium.WebDriver;
import core.configuration.Configs;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        WebDriverManager driverManager = new WebDriverManager();
        driverManager.setUp();
        driver = driverManager.getDriver();
    }

    @BeforeMethod
    public void setUp() {
//        driver.get(Configs.loginPage);
        driver.get(Configs.settingsPage);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}