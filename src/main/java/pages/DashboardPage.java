package pages;

import core.configuration.Configs;
import core.uttility.ElementChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private ElementChecker elementChecker;


    private By openDashboard = By.xpath(" //a[contains(@class, 'sidebarButton__nav-link--2TC0L') and contains(@href, '#default_personal/dashboard')]");
    private By addDB = By.xpath("//span[@class = 'ghostButton__text--eUa9T']");
    private By inputFieldName = By.xpath("//input[@class='input__input--3DC8i type-text variant-standard input__error--3ZvLE' and @placeholder='Enter dashboard name']");
    private By updateField = By.xpath("//input[@placeholder='Enter dashboard name']");
    private By addButton = By.xpath("//button[contains(@class, 'bigButton__big-button') and contains(@class, 'bigButton__color-booger')]");
    private By editDB = By.xpath("//i[@class = 'icon__icon--2m6Od icon__icon-pencil--2-R6b']");
    private By deleteDB = By.xpath("//i[@class = 'icon__icon--2m6Od icon__icon-delete--1jIHF']");
    private By deleteButton = By.xpath("//button[@class = 'bigButton__big-button--ivY7j bigButton__color-tomato--Wvy5L']");
    private By updateButton = By.xpath("//button[@class = 'bigButton__big-button--ivY7j bigButton__color-booger--2IfQT']']");
    private By successMessage = By.xpath("//div[@class= 'notificationItem__message-container--16jY2 notificationItem__success--Xv97a']");


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        elementChecker = new ElementChecker(driver);
    }

    public void openDashboards() {
        driver.get(Configs.dashboardPage);
//        driver.findElement(openDashboard).click();
    }

    public void addNewDashboard() {
        driver.findElement(addDB).click();
    }

    public void enterName(String dashboardName) {
        driver.findElement(inputFieldName).sendKeys(dashboardName);
    }
    public void updateName(String name) {
        driver.findElement(updateField).sendKeys(name);
    }

    public void clicksSaveDashboard() {
        driver.findElement(addButton).click();
    }

    public void editDashboard() {
        driver.findElement(editDB).click();
    }

    public void clickUpdateButton() {
        driver.findElement(updateButton).click();
    }

    public void clickDeleteDashboard() {
        driver.findElement(deleteDB).click();
        driver.findElement(deleteButton).click();
    }


    public void addNewDashboard(String dashboardName) {
        openDashboards();
        addNewDashboard();
        enterName(dashboardName);
        clicksSaveDashboard();
        elementChecker.checkElementAndReport(successMessage, "No success message displayed");
    }

    public void editDashboard(String name) {
        openDashboards();
        editDashboard();
        updateName(name);
        clickUpdateButton();
        elementChecker.checkElementAndReport(successMessage, "No success message displayed");
    }

    public void deleteDashboard() {
        openDashboards();
        clickDeleteDashboard();
        elementChecker.checkElementAndReport(successMessage, "No success message displayed");
    }
}