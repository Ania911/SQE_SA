package tests;

import core.assertion.Assertion;
import core.pageActions.DashBoardActions;
import core.pageActions.LoginPageActions;
import locators.PageLocators;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


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
    @DisplayName("Test add dashboard")
    public void testEddDashboard() {
        String newDashboard = dashboard.addNewDashboard();
        assertion.assertTextPresent(PageLocators.dashboardName, newDashboard, "Element not found");
    }

    @Test()
    @DisplayName("Test edit dashboard")
    public void testEditDashboard() {
        String newDashboard = dashboard.editDashboard();
        assertion.assertTextPresent(PageLocators.dashboardName, newDashboard, "Element not found");
    }

    @Test()
    @DisplayName("Test delete dashboard")
    public void testWDeleteDashboard() {
        dashboard.deleteDashboard();
        assertion.assertTextPresent(PageLocators.successMessage, "Dashboard has been deleted", "Fail to delete dashboard");
    }
}