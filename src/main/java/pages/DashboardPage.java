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

    public void clickAddNewDashboard() {
        clickButton(locators.addNewDashboard);
    }

    public void enterName(String dashboardName) {
        enterText(locators.inputFieldName, dashboardName);
    }

    public void updateName(String name) {
       enterText(locators.updateField, name);
    }

    public void clicksSaveDashboard() {
        clickButton(locators.cancelButton);
    }

    public void clickEditDashboard() {
        clickButton(locators.editeDashboardButton);
    }

    public void clickUpdateButton() {
        clickButton(locators.confirmUpdateButton);
    }

    public void clickDeleteDashboard() {
        clickButton(locators.deleteDashboardButton);
        clickButton(locators.confirmDeleteButton);
    }


}