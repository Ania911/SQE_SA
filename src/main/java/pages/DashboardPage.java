package pages;

import core.configuration.UIConfig;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private PageLocators locators;

    public DashboardPage(WebDriver driver) {
        super(driver);
        driver.get(UIConfig.getDashboardPage());
        locators = new PageLocators();
    }

    public DashboardPage clickAddNewDashboard() {
        clickButton(locators.addNewDashboard);
        return this;
    }

    public DashboardPage enterName(String dashboardName) {
        enterText(locators.inputFieldName, dashboardName);
        return this;
    }

    public DashboardPage updateName(String name) {
        enterText(locators.updateField, name);
        return this;
    }

    public DashboardPage clicksSaveDashboard() {
        clickButton(locators.cancelButton);
        return this;
    }

    public DashboardPage clickEditDashboard() {
        clickButton(locators.editeDashboardButton);
        return this;
    }

    public DashboardPage clickUpdateButton() {
        clickButton(locators.confirmUpdateButton);
        return this;
    }

    public DashboardPage clickDeleteDashboard() {
        clickButton(locators.deleteDashboardButton);
        clickButton(locators.confirmDeleteButton);
        return this;
    }


}