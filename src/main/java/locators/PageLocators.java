package locators;

import org.openqa.selenium.By;

public class PageLocators {
    // Log in page
    public static By userName = By.name("login");
    public static By pass = By.name("password");
    public static By loginButton = By.xpath("//button[text()='Login']");

    // Setting Page
    public static By settingsButton = By.xpath("//span[text()='Project settings']");
    public static By submitButton = By.xpath("//button[text()='Submit']");
    public By openInputDropdown = By.xpath("(//span[@class=\"inputDropdown__arrow--2eY6S\"])[2]");
    public static By inactivitySetting = By.xpath("//div[@title= '3 hours'] ");
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
    public By confirmUpdateButton = By.xpath("//button[text()='Update']");
    public By successAddDashboardMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()='Dashboard has been added']]\n");
    public static By successMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()='Dashboard has been deleted']]\n");

}
