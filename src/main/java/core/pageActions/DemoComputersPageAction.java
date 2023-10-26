package core.pageActions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.DemoComputersPage;

import java.util.List;
import java.util.Random;

public class DemoComputersPageAction extends DemoComputersPage {
    public DemoComputersPageAction(WebDriver driver) {
        super(driver);
    }

    @Step("Computer groups")
    public List<WebElement> getComputerCategory() {
        return getComputerSubGroup();
    }

    public void clickRandomCategoryLink() {
        // Generate a random index to select a category
        Random random = new Random();
        int randomIndex = random.nextInt(getComputerCategory().size());
        // Click the randomly selected category link
        getComputerCategory().get(randomIndex).click();
    }

    public void sortItems(String sortOption) {
        // Find the sorting dropdown element
        WebElement sortDropdown = getSortOrder();
        Select select = new Select(sortDropdown);
        // Select option by visible text
        select.selectByVisibleText(sortOption);
    }

    public void displayPerPage(Integer sortOption) {
        // Find the sorting dropdown element
        WebElement sortDropdown = getValueFromDropDown();
        Select select = new Select(sortDropdown);
        // Select option by visible text
        select.selectByVisibleText(String.valueOf(sortOption));
    }

    public void selectRandomItemAndAddToCart(By productGrid, By randomProduct) {
        selectRandomItem(productGrid, randomProduct);
        addItemsToCard();
    }

    public int getCartItemCount(By locator) {
        WebElement cartQtyElement = moveToElement(locator);
        String cartQtyText = cartQtyElement.getText();
        String numericPart = cartQtyText.replaceAll("[^0-9]", "");
        int cartItemCount = Integer.parseInt(numericPart);
        System.out.println("Cart Item Count: " + cartItemCount);
        return cartItemCount;
    }

    public void removeCartItem() {
        clickShoppingCard();
        clickRemoveCheckBox();
        clickUpdateCard();
    }
}
