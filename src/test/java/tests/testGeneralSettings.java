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
    private LoginPageActions actions;
    private SettingPageActions settingPage;

    @BeforeClass
    public void initializePage() {
        actions = new LoginPageActions(driver);
        actions.defaultUserLogin();
        settingPage = new SettingPageActions(driver);
    }

    @Test()
    public void testEditSettings() {
        settingPage.selectFromDropDown();
        Assertion.isElementPresent(PageLocators.inactivitySetting, "Element exists:", "Element not found");
    }

}

