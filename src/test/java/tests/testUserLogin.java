package tests;
import core.assertion.Assertion;
import core.dataProvider.DP;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class testUserLogin extends BaseTest{
    private LoginPage loginPage;
    private Assertion assertion;

    @BeforeClass
    public void initializePage() {
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "userData", dataProviderClass = DP.class)
    public void testUserLogin(String username, String password) {
        loginPage.userLogin(username,password);
        assertion.assertTitleEquals("Report Portal", "Title mismatch");
    }

}
