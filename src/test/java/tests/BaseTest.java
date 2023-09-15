package tests;
import core.uttility.WebDriverSetUp;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

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