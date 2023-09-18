package core.pageActions;

import core.assertion.Assertion;
import core.uttility.Log;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class DashBoardActions extends DashboardPage {
//    private Assertion assertion;
    public String dashboardName = generateRandomDashboardName();

    public DashBoardActions(WebDriver driver) {
        super(driver);
//        assertion = new Assertion(driver);
    }

    public void addNewDashboard() {
        Log.info("User add new dashboard");
        clickAddNewDashboard();
        enterName(dashboardName);
        clicksSaveDashboard();
        System.out.println(dashboardName);
    }
    public String getDashboardName() {
        return dashboardName;
    }

    public void editDashboard() {
        Log.info("User edit new dashboard");
        clickEditDashboard();
        updateName(dashboardName);
        clickUpdateButton();
    }

    public void deleteDashboard() {
        Log.info("User delete new dashboard");
        clickDeleteDashboard();
    }

    public String generateRandomDashboardName() {
        return RandomStringUtils.randomAlphanumeric(15);
    }

}
