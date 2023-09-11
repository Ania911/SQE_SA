package tests;

import core.assertion.Assertion;
import core.pageActions.LoginPageActions;
import core.pageActions.SettingPageActions;
import locators.PageLocators;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;

public class testGeneralSettings extends BaseTest {
    private LoginPage loginPage;
    private SettingsPage settings;
    private LoginPageActions act;
    private SettingPageActions sActions;
    private Assertion assertion;
    private PageLocators locators;

    @BeforeClass
    public void initializePage() {
        loginPage = new LoginPage(driver);
        act = new LoginPageActions(loginPage);
        act.defaultUserLogin();
        settings = new SettingsPage(driver);
        sActions = new SettingPageActions(settings);
        assertion = new Assertion(driver);
        locators = new PageLocators();
    }

    @Test()
    public void testEditSettings() {
        sActions.updateDataFromDropDown();
        assertion.assertSuccessMessageByLocator(locators.successSettingUpdateMessage, "Project settings were successfully updated", "Fail to update the project settings ");
    }

}

