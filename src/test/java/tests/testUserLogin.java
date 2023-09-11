package tests;
import core.assertion.Assertion;
import core.dataProvider.DP;
import core.pageActions.LoginPageActions;
import locators.PageLocators;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class testUserLogin extends BaseTest{
    private LoginPage loginPage;
    private LoginPageActions actions;
    private Assertion assertion;
    private PageLocators locators;

    @BeforeClass
    public void initializePage() {
        loginPage = new LoginPage(driver);
        assertion= new Assertion(driver);
        actions = new LoginPageActions(loginPage);
        locators = new PageLocators();
    }

    @Test(dataProvider = "userData", dataProviderClass = DP.class)
    public void testUserLogin(String username, String password) {
        actions.userLogin(username,password);
        assertion.assertSuccessMessageByLocator(locators.successLogInMessage,"Signed in successfully", "Signed in failed");
    }

}
