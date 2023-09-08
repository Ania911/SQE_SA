package tests;

import core.pageActions.LoginPageActions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class testCRUDDashboard extends BaseTest {

    private DashboardPage dashboardPage;
    private LoginPageActions actions;
    private LoginPage loginPage;

    @BeforeClass
    public void initializePage() {
        loginPage = new LoginPage(driver);
        actions = new LoginPageActions(loginPage);
        dashboardPage = new DashboardPage(driver);
        actions.defaultUserLogin();
    }

    @Test()
    public void testEddDashboard() {
        dashboardPage.addNewDashboard("TestSA1");
    }

    @Test()
    public void testEditDashboard() {
        dashboardPage.editDashboard("TestSA13333");
    }

    @Test()
    public void testDeleteDashboard() {
        dashboardPage.deleteDashboard();
    }
}