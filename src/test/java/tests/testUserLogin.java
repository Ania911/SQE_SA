package tests;

import core.assertion.Assertion;
import core.dataProvider.DP;
import core.pageActions.LoginPageActions;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import locators.PageLocators;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.*;

@Feature("User management")
@Story("User log in")
public class testUserLogin extends BaseTest {
    private LoginPageActions actions;
    private Assertion assertion;

    @BeforeClass
    public void initializePage() {
        actions = new LoginPageActions(driver);
        assertion = new Assertion(actions);
    }

    @Test(dataProvider = "userData", dataProviderClass = DP.class)
    @DisplayName("Test success user login")
    public void testUserLogin(String username, String password) {
        actions
                .userLogin(username, password);
        assertion.assertElementPresent(PageLocators.settingsButton, "Element not found");
    }


}
