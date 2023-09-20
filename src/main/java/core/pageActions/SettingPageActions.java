package core.pageActions;

import core.assertion.Assertion;
import core.uttility.Log;
import org.openqa.selenium.WebDriver;
import pages.SettingsPage;

public class SettingPageActions extends SettingsPage {

    public SettingPageActions(WebDriver driver) {
        super(driver);
    }

    public void selectFromDropDown() {
        Log.info("User Open Dropdown");
        openDropDown();
        Log.info("User change settings");
        selectOptionFromDropDown();
        Log.info("User click save button");
        clickSubmitButton();
    }
}
