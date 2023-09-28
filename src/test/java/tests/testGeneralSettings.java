package tests;

import core.assertion.Assertion;
import core.pageActions.LoginPageActions;
import core.pageActions.SettingPageActions;
import locators.PageLocators;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testGeneralSettings extends BaseTest {
    private LoginPageActions actions;
    private SettingPageActions settingPage;
    private Assertion assertion;

    @BeforeClass
    public void initializePage() {
        actions = new LoginPageActions(driver);
        actions.defaultUserLogin();
        settingPage = new SettingPageActions(driver);
        assertion = new Assertion(actions);
    }

    @Test()
    @DisplayName("Test edit user settings")
    public void testEditSettings() {
        String option = "6 hours";
        settingPage.selectFromDropDown(option);
        assertion.assertElementPresent(settingPage.getOptionText(option), option, "Element not found");
    }
}

