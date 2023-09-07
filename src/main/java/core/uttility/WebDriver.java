package core.uttility;

import core.configuration.Configs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriver {
    private org.openqa.selenium.WebDriver driver;

    public void setUp() {
//         Get the browser configuration value from the config
        String browser = Configs.browser;
        String browserSize = Configs.browserSize;

//        Initialize the WebDriver based on the browser
        if ("chrome".equalsIgnoreCase(browser)) {
//            https://bonigarcia.dev/webdrivermanager/ - setup gecko driver
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
//            Check the window screen
            setScreenResolution(chromeOptions, browserSize);
            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            setScreenResolution(firefoxOptions, browserSize);
            driver = new FirefoxDriver(firefoxOptions);
        }

        // Initialize WebDriverWait with a timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    private void setScreenResolution(Object options, String browserSize) {
        if ("maximized".equalsIgnoreCase(browserSize)) {
            if (options instanceof ChromeOptions) {
                ((ChromeOptions) options).addArguments("--start-maximized");
            } else if (options instanceof FirefoxOptions) {
                ((FirefoxOptions) options).addArguments("--start-maximized");
            }
        } else if ("custom".equalsIgnoreCase(browserSize)) {
            ((ChromeOptions) options).addArguments("--window-size=1280,1024");
        }
    }

    public org.openqa.selenium.WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void tearDown() {
        driver.quit();
    }

}
