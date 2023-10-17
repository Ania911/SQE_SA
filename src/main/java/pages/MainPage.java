package pages;

import core.configuration.UIConfig;
import io.qameta.allure.Step;
import locators.Locators;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private Locators locators;

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(UIConfig.getMainPage());
        locators = new Locators();
    }

    public MainPage toggleSwitch() {
        clickButton(locators.modeToggle);
        return this;
    }

    public MainPage moveToElement() {
        moveToElement(locators.modeToggle);
        return this;
    }

    @Step("Switch Mode")
    public MainPage switchToggle() {
        toggleSwitch();
        moveToElement();
        return this;
    }
    @Step("Switch Languages")
    public MainPage changeLanguage() {
        clickButton(locators.languages);
        clickButton(locators.selectUkLanguage);
        return this;
    }
}
