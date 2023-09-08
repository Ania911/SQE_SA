package core.pageActions;

import core.uttility.Log;
import pages.SettingsPage;

public class SettingPageActions {
    private SettingsPage settingPage;

    public SettingPageActions(SettingsPage settingPage) {
        this.settingPage = settingPage;
    }
    public void updateDataFromDropDown() {
        Log.info("User Open Dropdown");
        settingPage.openDropDown();
        settingPage.dropDownOptions();
        Log.info("User click save button");
        settingPage.clickSubmitButton();
    }
}
