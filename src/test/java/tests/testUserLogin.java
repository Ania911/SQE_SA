package tests;
import core.dataProvider.DP;
import core.uttility.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import core.uttility.Log;
import static core.configuration.Configs.baseURL;
import static core.configuration.Configs.loginScreen;

public class testUserLogin {
    private WebDriver driver;
    private WebDriverManager driverManager;

    @BeforeClass
    public void setUp() {
        driverManager = new WebDriverManager();
        driverManager.setUp();
        driver = driverManager.getDriver();
        driver.get("http://localhost:8080/ui/#login");
    }
    @Test(dataProvider = "userData")
    public void testSignIn(String username, String password, String userType,  String expected) {
        // Fill in username and password fields
        driver.findElement(By.name("login")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@class, 'bigButton__color-organish')]")).click();

        // Implement assertions based on expected result
        if (expected.equals("Success")) {
            // Verify successful login
        } else {
            // Verify error message
        }

        // Clear fields for the next iteration
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
    }

    @Test(dataProvider = "userLogin", dataProviderClass = DP.class)
    public void userLogin (String name, String pass) {
        Log.info("Testing logger");
        System.out.println("User Logins : " + name +" "+ pass);
    }
}
