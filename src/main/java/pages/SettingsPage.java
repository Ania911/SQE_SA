package pages;

import core.configuration.Configs;
import core.uttility.CommonUIActions;
import locators.PageLocators;
import org.openqa.selenium.WebDriver;

public class SettingsPage {
    private WebDriver driver;
    private CommonUIActions commonActions;
    private PageLocators locators;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        locators = new PageLocators();
        commonActions = new CommonUIActions(driver);
        driver.get(Configs.settingsPage);
    }

    public void openDropDown() {
        commonActions.clickButton(locators.openDropdown);
    }

    public void dropDownOptions() {
        commonActions.clickButton(locators.titles);
    }

    public void clickSubmitButton() {
        commonActions.clickButton(locators.submitButton);
    }

}
