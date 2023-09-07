package pages;

import core.configuration.Configs;
import core.assertion.ElementChecker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {
    private WebDriver driver;
    private ElementChecker elementChecker;
    private By settingsButton = By.xpath("//span[@class = 'sidebarButton__btn-title-mobile--j8jhQ']");
    private By submitButton = By.xpath("//button[@type= 'submit']");
    private By openDropdown = By.xpath("(//span[@class=\"inputDropdown__value--2gB2s\"])[2]");
    private By titles = By.xpath("//div[@title= '3 hours'] ");
    private By successMessage = By.xpath("//div[@class= 'notification-transition-enter-done']");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        elementChecker = new ElementChecker(driver);
        driver.get(Configs.settingsPage);
    }

    public void clickSettingsButton() {
      driver.findElement(settingsButton).click();
    }

    public void openDropDown() {
        driver.findElement(openDropdown).click();
    }

    public void dropDownOptions() {
        driver.findElement(titles).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    // Get the currently selected option
    public void updateDataFromDropDown() {
//       clickSettingsButton();
        openDropDown();
        dropDownOptions();
        clickSubmitButton();
        elementChecker.checkElementAndReport(successMessage, "No success message displayed");
    }
}
