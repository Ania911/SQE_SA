package tests.demoWebShop;

import core.assertion.Assertion;
import core.dataProvider.DP;
import core.pageActions.DemoComputersPageAction;
import locators.Locators;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

public class testComputersTab extends BaseTest {
    private DemoComputersPageAction computerPage;
    private Assertion assertion;

    @BeforeClass
    public void initializePage() {
        computerPage = new DemoComputersPageAction(driver);
        assertion = new Assertion(computerPage);
    }

    @Test()
    @DisplayName("Verify that ‘Computers’ group has 3 sub-groups with correct names")
    public void testComputerGroups() {
        List<WebElement> category = computerPage.getComputerCategory();
        String[] expectedCategoryNames = {"Desktops", "Notebooks", "Accessories"};
        assertion.assertSubGroups(category, 3, expectedCategoryNames);
    }

    @Test(dataProvider = "sortingOptions", dataProviderClass = DP.class)
    @DisplayName("Verify that allows sorting items (different options)")
    public void testSortingOptions(String sortingOptions) {
        computerPage.clickRandomCategoryLink();
        computerPage.sortItems(sortingOptions);
        assertion.assertTextPresent(Locators.productTitle, sortingOptions, "Wrong sorting options");
    }

    @Test(dataProvider = "numberPerPage", dataProviderClass = DP.class)
    @DisplayName("Verify that allows changing number of items on page")
    public void testDisplayNumberPerPage(Integer numberPerPage) {
        computerPage.clickRandomCategoryLink();
        computerPage.displayPerPage(numberPerPage);
        assertion.assertTextPresent(Locators.numberPerPage, String.valueOf(numberPerPage), "Wrong number per page");
    }

    @Test()
    @DisplayName("Verify that allows adding an item to the card")
    public void testAddingItemsToCard() {
        computerPage.clickRandomCategoryLink();
        computerPage.selectRandomItemAndAddToCart(Locators.productGrid, Locators.productItems);
        int cartQty= computerPage.getCartItemCount(Locators.shoppingCardItems);
        assertion.assertCartHasItems(cartQty);
    }

    @Test()
    @DisplayName("Verify that allows removing an item from the card")
    public void testRemoveItemsFromCard() {
        computerPage.clickRandomCategoryLink();
        computerPage.selectRandomItemAndAddToCart(Locators.productGrid, Locators.productItems);
        computerPage.removeCartItem();
        assertion.assertTextPresent(Locators.emptyShoppingCart,"Your Shopping Cart is empty!","Error");
    }

    @Test()
    @DisplayName("Verify that allows checkout an item")
    public void testCheckOutItem() {
        computerPage.clickRandomCategoryLink();
        computerPage.selectRandomItemAndAddToCart(Locators.productGrid, Locators.productItems);
        assertion.assertTextPresent(Locators.emptyShoppingCart,"Your Shopping Cart is empty!","Error");
    }


}
