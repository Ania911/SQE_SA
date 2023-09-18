package pages;

import core.configuration.Configs;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage{
    private PageLocators locators;

    public SettingsPage(WebDriver driver) {
        super(driver);
        driver.get(Configs.getSettingsPage());
        locators = new PageLocators();
    }

    public void openDropDown() {
        clickButton(locators.openInputDropdown);
    }

    public void selectOptionFromDropDown() {
        clickButton(locators.inactivitySetting);
    }

    public void clickSubmitButton() {
        clickButton(locators.submitButton);
    }

}
