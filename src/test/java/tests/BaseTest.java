package tests;
import core.assertion.Assertion;
import core.pageActions.LoginPageActions;
import core.uttility.WebDriverSetUp;
import locators.PageLocators;
import org.testng.annotations.*;
import pages.LoginPage;

public class BaseTest {
    protected org.openqa.selenium.WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        try {
            WebDriverSetUp driverManager = new WebDriverSetUp();
            driverManager.setUp();
            driver = driverManager.getDriver();
        } catch (Exception e) {
            System.err.println("Driver setup failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}