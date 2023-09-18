package core.uttility;

import core.configuration.Configs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverSetUp {
    private WebDriver driver;

    public void setUp() {
//         Get the browser configuration value from the config
        String browser = Configs.getBrowser();
        String browserSize = Configs.getBrowserSize();
        try {
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
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        } catch (Exception e) {
            logError("Failed to start the WebDriver: " + e.getMessage());
        }
    }

    private void setScreenResolution(Object options, String browserSize) {
        if ("maximized".equalsIgnoreCase(browserSize)) {
            if (options instanceof ChromeOptions) {
                ((ChromeOptions) options).addArguments("--start-maximized");
            } else if (options instanceof FirefoxOptions) {
                ((FirefoxOptions) options).addArguments("--start-maximized");
            }
        } else if ("custom".equalsIgnoreCase(browserSize)) {
            if (options instanceof ChromeOptions) {
                ((ChromeOptions) options).addArguments("--window-size=1280,1024");
            } else if (options instanceof FirefoxOptions) {
                ((FirefoxOptions) options).addArguments("--width=1280", "--height=1024");
            }
        }
    }

    private void logError(String errorMessage) {
        System.err.println("ERROR: " + errorMessage);
    }

    public org.openqa.selenium.WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        driver.quit();
    }

}
