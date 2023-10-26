package tests.demoWebShop;

import core.assertion.Assertion;
import core.dataProvider.DP;
import core.pageActions.DemoLoginPageAction;
import core.pageActions.DemoRegisterPageAction;
import locators.Locators;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DemoLoginPage;
import tests.BaseTest;

public class testUserRegistration extends BaseTest {
    private DemoRegisterPageAction actions;
    private DemoLoginPageAction loginPage;
    private Assertion assertion;

    @BeforeClass
    public void initializePage() {
        actions = new DemoRegisterPageAction(driver);
        assertion = new Assertion(actions);
    }

    @Test(dataProvider = "userRegistrationData", dataProviderClass = DP.class)
    @DisplayName("Verify that allows register a User")
    public void testNewUserRegistration(String username, String lastUserName, String pass, String password) {
        actions
                .userRegistration(username, lastUserName, pass, password);
        assertion.assertTextPresent(Locators.confirmRegistration, "Your registration completed","Element not found");
    }

    @Test(dataProvider = "login", dataProviderClass = DP.class)
    @DisplayName("Verify that allows login a User")
    public void testUserLogin(String email,  String password) {
        loginPage = new DemoLoginPageAction(driver);
        loginPage
                .userLogin(email, password);
        assertion.assertTextPresent(Locators.logOutButton, "Log out","Element not found");
    }

}
