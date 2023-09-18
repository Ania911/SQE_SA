package tests;
import core.assertion.Assertion;
import core.dataProvider.DP;
import core.pageActions.LoginPageActions;
import locators.PageLocators;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testUserLogin extends BaseTest {
    private LoginPageActions actions;

    @BeforeClass
    public void initializePage() {
        actions = new LoginPageActions(driver);
    }

    @Test(dataProvider = "userData", dataProviderClass = DP.class)
    public void testUserLogin(String username, String password) {
        actions.userLogin(username,password);
        Assertion.isElementPresent(PageLocators.settingsButton,"Element exists:", "Element not found:");
    }

}
