package core.pageActions;

import core.uttility.Log;
import org.apache.commons.lang.RandomStringUtils;
import pages.DashboardPage;
import pages.SettingsPage;

public class DashBoardActions {
    private DashboardPage dashboardPage;

    public DashBoardActions(DashboardPage dashboardPage) {
        this.dashboardPage = dashboardPage;
    }

    public void addNewDashboard() {
        String dashboardName = generateRandomDashboardName();
        Log.info("User add new dashboard");
        dashboardPage.addNewDashboard();
        dashboardPage.enterName(dashboardName);
        dashboardPage.clicksSaveDashboard();
    }

    public void editDashboard() {
        String dashboardName = generateRandomDashboardName();
        Log.info("User edit new dashboard");
        dashboardPage.editDashboard();
        dashboardPage.updateName(dashboardName);
        dashboardPage.clickUpdateButton();
    }

    public void deleteDashboard() {
        Log.info("User delete new dashboard");
        dashboardPage.clickDeleteDashboard();
    }

    public String generateRandomDashboardName() {
        return RandomStringUtils.randomAlphanumeric(15);
    }

}
