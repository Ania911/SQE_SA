package locators;

import org.openqa.selenium.By;

public class PageLocators {
    // Log in page
    public By userName = By.name("login");
    public By pass = By.name("password");
    public By loginButton = By.xpath("//button[text()='Login']");

    // Setting Page
    public By settingsButton = By.xpath("//span[text()='Project settings']");
    public By submitButton = By.xpath("//button[text()='Submit']");
    public By openInputDropdown = By.xpath("(//span[@class=\"inputDropdown__value--2gB2s\"])[2]");
    public By lunchInactivityTimeoutField = By.xpath("//div[@title= '3 hours'] ");
    public By successLogInMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()= 'Signed in successfully']]");
    public By successSettingUpdateMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()='Project settings were successfully updated']]\n");

    // Dashboard Page
    // Add new Dashboard
    public By openDashboard = By.xpath("//span[text()='Dashboards']");
    public By addNewDashboard = By.xpath("//span[text()=\"Add New Dashboard\"]");
    public By inputFieldName = By.xpath("//input[@placeholder='Enter dashboard name']");
    public By updateField = By.xpath("//input[@placeholder='Enter dashboard name']");
    public By addDashboardButton = By.xpath("//button[text()='Add']");
    public By cancelButton = By.xpath("//button[text()='Cancel']");
    // Update  Dashboard
    public By editeDashboardButton = By.xpath("//i[@class = 'icon__icon--2m6Od icon__icon-pencil--2-R6b']");
    public By deleteDashboardButton = By.xpath("//i[@class = 'icon__icon--2m6Od icon__icon-delete--1jIHF']");
    public By confirmDeleteButton = By.xpath("//button[text()='Delete']");
    public By confirmUpdateButton = By.xpath("///button[text()='Update']");
    public By successAddDashboardMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()='Dashboard has been added']]\n");
    public By successDeleteDashboardMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()='Dashboard has been deleted']]\n");

}
