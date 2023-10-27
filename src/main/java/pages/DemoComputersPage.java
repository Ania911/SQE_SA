package pages;

import core.configuration.UIConfig;
import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoComputersPage extends BasePage {
    private Locators locators;

    public DemoComputersPage(WebDriver driver) {
        super(driver);
        driver.get(UIConfig.getComputerPage());
        locators = new Locators();
    }

    public DemoComputersPage getComputerGroup() {
        findElement(locators.computersGroup);
        return this;
    }

    public DemoComputersPage clickComputerPage() {
        clickButton(locators.computersPage);
        return this;
    }

    public List<WebElement> getComputerSubGroup() {
        return findElements(locators.computersSubGroups);
    }

    public WebElement getSortOrder() {
        WebElement order = findElement(locators.computersSortOrder);
        return order;
    }

    public WebElement getValueFromDropDown() {
        WebElement order = findElement(locators.selectNumberPerPage);
        return order;
    }

    public DemoComputersPage addItemsToCard() {
        clickButton(locators.addToCart);
        return this;
    }

    public DemoComputersPage clickRemoveCheckBox() {
        clickButton(locators.removeCheckBox);
        return this;
    }

    public DemoComputersPage clickUpdateCard() {
        clickButton(locators.updateCard);
        return this;
    }

    public DemoComputersPage clickShoppingCard() {
        clickButton(locators.shoppingCard);
        return this;
    }

    public DemoComputersPage clickAgreementCheckbox() {
        clickButton(locators.agreementCheckBox);
        return this;
    }

    public DemoComputersPage clickCheckoutButton() {
        clickButton(locators.checkoutButton);
        return this;
    }

}
