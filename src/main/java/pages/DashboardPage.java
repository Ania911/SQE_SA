package pages;

import core.configuration.Configs;
import core.uttility.CommonUIActions;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private CommonUIActions commonActions;
    private PageLocators locators;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Configs.dashboardPage);
        locators = new PageLocators();
        commonActions = new CommonUIActions(driver);
    }

    public void addNewDashboard() {
        commonActions.clickButton(locators.addDB);
    }

    public void enterName(String dashboardName) {
        commonActions.enterText(locators.inputFieldName, dashboardName);
    }

    public void updateName(String name) {
        commonActions.enterText(locators.updateField, name);
    }

    public void clicksSaveDashboard() {
        commonActions.clickButton(locators.addButton);
    }

    public void editDashboard() {
        commonActions.clickButton(locators.editDB);
    }

    public void clickUpdateButton() {
        commonActions.clickButton(locators.updateButton);
    }

    public void clickDeleteDashboard() {
        commonActions.clickButton(locators.deleteDB);
        commonActions.clickButton(locators.deleteButton);
    }

}