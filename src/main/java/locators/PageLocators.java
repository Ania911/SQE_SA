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

}
