package tests;

import core.assertion.Assertion;
import core.pageActions.DashBoardActions;
import core.pageActions.LoginPageActions;
import locators.PageLocators;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class testCRUDDashboard extends BaseTest {

    private DashboardPage dashboardPage;
    private LoginPageActions actions;
    private LoginPage loginPage;
    private DashBoardActions dashboardAct;
    private Assertion assertion;
    private PageLocators locators;

    @BeforeClass
    public void initializePage() {
        loginPage = new LoginPage(driver);
        actions = new LoginPageActions(loginPage);
        actions.defaultUserLogin();
        dashboardPage = new DashboardPage(driver);
        dashboardAct = new DashBoardActions(dashboardPage);
        assertion = new Assertion(driver);
        locators = new PageLocators();
    }

    @Test()
    public void testEddDashboard() {
        dashboardAct.addNewDashboard();
        assertion.assertSuccessMessageByLocator(locators.successAddDashboardMessage, "Dashboard has been added", "Fail to add new dashboard");
    }

    @Test()
    public void testEditDashboard() {
        dashboardAct.editDashboard();
        assertion.assertSuccessMessageByLocator(locators.successAddDashboardMessage, "Dashboard has been updated", "Fail to update dashboard");
    }

    @Test()
    public void testDeleteDashboard() {
        dashboardAct.deleteDashboard();
        assertion.assertSuccessMessageByLocator(locators.successDeleteDashboardMessage, "Dashboard has been deleted", "Fail to delete dashboard");
    }
}