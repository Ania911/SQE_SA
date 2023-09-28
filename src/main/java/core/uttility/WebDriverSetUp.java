package core.uttility;

import core.configuration.UIConfig;
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
        String browser = UIConfig.getBrowser();
        String browserSize = UIConfig.getBrowserSize();
        String chromeOptionsFromConfig = UIConfig.getChromeOptions();
        String firefoxOptionsFromConfig = UIConfig.getFirefoxOptions();
        try {
//        Initialize the WebDriver based on the browser
            if ("chrome".equalsIgnoreCase(browser)) {
//            https://bonigarcia.dev/webdrivermanager/ - setup gecko driver
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                if ("maximized".equalsIgnoreCase(browserSize) && chromeOptionsFromConfig != null && !chromeOptionsFromConfig.isEmpty()) {
                    String[] chromeOptionsArray = chromeOptionsFromConfig.split(",\\s*");
                    chromeOptions.addArguments(chromeOptionsArray);
                }
                driver = new ChromeDriver(chromeOptions);
            } else if ("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if ("maximized".equalsIgnoreCase(browserSize) && firefoxOptionsFromConfig != null && !firefoxOptionsFromConfig.isEmpty()) {
                    String[] firefoxOptionsArray = firefoxOptionsFromConfig.split(",\\s*");
                    firefoxOptions.addArguments(firefoxOptionsArray);
                }
                driver = new FirefoxDriver(firefoxOptions);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        } catch (Exception e) {
            logError("Failed to start the WebDriver: " + e.getMessage());
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
