package core.pageActions;

import core.assertion.Assertion;
import core.uttility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SettingsPage;

public class SettingPageActions extends SettingsPage {

    public SettingPageActions(WebDriver driver) {
        super(driver);
    }

    public SettingPageActions selectFromDropDown(String option) {
        By locator = getOptionText(option);
        Log.info("User Open Dropdown");
        openDropDown();
        Log.info("User change settings");
        selectOptionFromDropDown(locator);
        Log.info("User click save button");
        clickSubmitButton();
        return this;
    }

    public By getOptionText(String optionText) {
        return By.xpath("//div[@class='inputDropdownOption__single-option--NDwbb' and @title='" + optionText + "']");
    }
}
