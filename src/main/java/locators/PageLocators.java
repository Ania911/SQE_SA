package locators;

import org.openqa.selenium.By;

public class PageLocators {
    // Log in page
    public By userName = By.name("login");
    public By pass = By.name("password");
    public By loginButton = By.xpath("//button[contains(@class, 'bigButton__color-organish')]");

    // Setting Page
    public By settingsButton = By.xpath("//span[@class = 'sidebarButton__btn-title-mobile--j8jhQ']");
    public By submitButton = By.xpath("//button[@type= 'submit']");
    public By openDropdown = By.xpath("(//span[@class=\"inputDropdown__value--2gB2s\"])[2]");
    public By titles = By.xpath("//div[@title= '3 hours'] ");
    public By successLogInMessage = By.xpath("//div[contains(@class, 'notificationItem__success')]//p[contains(text(), 'Signed in successfully')]\n");
    public By successSettingUpdateMessage = By.xpath("//div[contains(@class, 'notificationItem__success')]//p[contains(text(), 'Project settings were successfully updated')]");

    // Dashboard Page
    public By openDashboard = By.xpath(" //a[contains(@class, 'sidebarButton__nav-link--2TC0L') and contains(@href, '#default_personal/dashboard')]");
    public By addDB = By.xpath("//span[@class = 'ghostButton__text--eUa9T']");
    public By inputFieldName = By.xpath("//input[@class='input__input--3DC8i type-text variant-standard input__error--3ZvLE' and @placeholder='Enter dashboard name']");
    public By updateField = By.xpath("//input[@placeholder='Enter dashboard name']");
    public By addButton = By.xpath("//button[contains(@class, 'bigButton__big-button') and contains(@class, 'bigButton__color-booger')]");
    public By editDB = By.xpath("//i[@class = 'icon__icon--2m6Od icon__icon-pencil--2-R6b']");
    public By deleteDB = By.xpath("//i[@class = 'icon__icon--2m6Od icon__icon-delete--1jIHF']");
    public By deleteButton = By.xpath("//button[@class = 'bigButton__big-button--ivY7j bigButton__color-tomato--Wvy5L']");
    public By updateButton = By.xpath("//button[@class = 'bigButton__big-button--ivY7j bigButton__color-booger--2IfQT']']");
    public By successAddDashboardMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()='Dashboard has been added']]\n");
    public By successDeleteDashboardMessage = By.xpath("//div[contains(@class, 'notificationItem__success') and .//p[text()='Dashboard has been deleted']]\n");

}
