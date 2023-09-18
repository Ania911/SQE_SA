package tests;

import core.assertion.Assertion;
import core.pageActions.DashBoardActions;
import core.pageActions.LoginPageActions;
import locators.PageLocators;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;


public class testCRUDDashboard extends BaseTest {

    private LoginPageActions actions;
    private DashBoardActions dashboard;
    private Assertion assertion;

    @BeforeClass
    public void initializePage() {
        actions = new LoginPageActions(driver);
        actions.defaultUserLogin();
        dashboard = new DashBoardActions(driver);
        assertion = new Assertion(dashboard);
    }

    @Test()
    public void testEddDashboard() {
        dashboard.addNewDashboard();
        String returnedDashboardName = dashboard.getDashboardName();
        Assert.assertEquals(returnedDashboardName, dashboard.dashboardName);
    }

    @Test()
    public void testEditDashboard() {
        dashboard.editDashboard();
        String returnedDashboardName = dashboard.getDashboardName();
        Assert.assertEquals(returnedDashboardName, dashboard.dashboardName);
    }

    @Test()
    public void testDeleteDashboard() {
        dashboard.deleteDashboard();
        assertion.assertSuccessMessageByLocator(PageLocators.successMessage, "Dashboard has been deleted", "Fail to delete dashboard");
    }
}