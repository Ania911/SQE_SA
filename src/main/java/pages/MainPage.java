package pages;

import core.configuration.UIConfig;
import io.qameta.allure.Step;
import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.List;

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
    @Step("Enter search query")
    public MainPage searchQuery(String text) {
        clickButton(locators.searchIcon);
        enterText(locators.inputSearchField, text);
        return this;
    }
    @Step("Ask form required fields")
    public void checkFieldsAreRequired(List<String> fieldNames) {
        for (String fieldName : fieldNames) {
            By fieldLocator = By.xpath("//input[@name='" + fieldName + "']");
            String ariaRequired = getTextByAttribute(fieldLocator, "aria-required");

            if ("true".equals(ariaRequired)) {
                System.out.println("The " + fieldName + " field is required.");
            } else {
                System.out.println("The " + fieldName + " field is not required.");
            }
        }
    }

}
