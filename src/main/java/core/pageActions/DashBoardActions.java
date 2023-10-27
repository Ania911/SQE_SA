package core.pageActions;

import core.assertion.Assertion;
import core.uttility.Log;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class DashBoardActions extends DashboardPage {
    private String dashboardName = generateRandomDashboardName();

    public DashBoardActions(WebDriver driver) {
        super(driver);
    }

    public String addNewDashboard() {
        clickAddNewDashboard()
                .enterName(dashboardName)
                .clicksSaveDashboard();
        return dashboardName;
    }

    public String editDashboard() {
        clickEditDashboard()
                .updateName(dashboardName)
                .clickUpdateButton();
        return dashboardName;
    }

    public void deleteDashboard() {
        clickDeleteDashboard();
    }

    public String generateRandomDashboardName() {
        return RandomStringUtils.randomAlphanumeric(15);
    }

}
