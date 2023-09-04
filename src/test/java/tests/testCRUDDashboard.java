package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class testCRUDDashboard extends BaseTest {

    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @BeforeClass
    public void initializePage() {
        dashboardPage = new DashboardPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test()
    public void testEddDashboard() {
        loginPage.userLogin("default", "1q2w3e");
        dashboardPage.addNewDashboard("TestSA1");
    }

    @Test()
    public void testEditDashboard() {
        loginPage.userLogin("default", "1q2w3e");
        dashboardPage.editDashboard("TestSA13333");
    }
    @Test()
    public void testDeleteDashboard() {
        loginPage.userLogin("default", "1q2w3e");
        dashboardPage.deleteDashboard();
    }
}
