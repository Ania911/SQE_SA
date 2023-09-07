package locators;

import org.openqa.selenium.By;

public class PageLocators {
    public By userName = By.name("login");
    public By pass = By.name("password");
    public By loginButton = By.xpath("//button[contains(@class, 'bigButton__color-organish')]");

}
