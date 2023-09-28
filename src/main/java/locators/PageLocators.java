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
    public By openInputDropdown = By.xpath("(//div[@class='inputDropdown__dropdown-container--2CVaC'])[2]\n");

    // Dashboard Page
    // Add new Dashboard
    public By openDashboard = By.xpath("//span[text()='Dashboards']");
    public By addNewDashboard = By.xpath("//span[text()=\"Add New Dashboard\"]");
    public By inputFieldName = By.xpath("//input[@placeholder='Enter dashboard name']");
    public By updateField = By.xpath("//input[@placeholder='Enter dashboard name']");
    public By addDashboardButton = By.xpath("//button[text()='Add']");
    public By cancelButton = By.xpath("//button[text()='Cancel']");
    // Update  Dashboard
    public By editeDashboardButton = By.xpath("//i[contains(@class, 'pencil')]");
    public By deleteDashboardButton = By.xpath("//i[contains(@class, 'delete')]");
    public By confirmDeleteButton = By.xpath("//button[text()='Delete']");
    public By confirmUpdateButton = By.xpath("//button[text()='Update']");
    public static By dashboardName = By.xpath("//a[contains(@class, 'dashboardTable')]");
    public By successAddDashboardMessage = By.xpath("//p[text()='Dashboard has been added']");
    public static By successMessage = By.xpath("//p[text()='Dashboard has been deleted']");

}
