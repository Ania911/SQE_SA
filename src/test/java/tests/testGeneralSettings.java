package tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;

public class testGeneralSettings extends BaseTest {
    private SettingsPage settings;
    private LoginPage loginPage;

    @BeforeClass
    public void initializePage() {
        settings = new SettingsPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test()
    public void testEditSettings() {
        loginPage.userLogin("default", "1q2w3e");
        settings.updateDataFromDropDown();
    }

}

