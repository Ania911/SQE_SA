package core.uttility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WebDriverManager {
    private WebDriver driver;

//    Cross browsers (String browsers) +if/else
//    capabilities- screen res
// https://bonigarcia.dev/webdrivermanager/ - setup chrome driver
//    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        // Initialize WebDriverWait with a timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

//    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
