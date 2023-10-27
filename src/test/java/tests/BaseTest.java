package tests;

import core.uttility.WebDriverSetUp;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;


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

    @AfterMethod
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureAndAttachScreenshot();
        }
    }

    private void captureAndAttachScreenshot() {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment("Screenshot on Failure", "image/png", new ByteArrayInputStream(screenshot), "png");
        } catch (Exception e) {
            // Handle any exceptions that occur during screenshot capture
            System.err.println("Error capturing or attaching screenshot: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}