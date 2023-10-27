package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By title = By.xpath("//img[@alt='EPAM']");
    public static By modeToggle = By.xpath("(//div[@class='switch'])[2]");
    public static By lightMode = By.xpath("(//span[text()='Light Mode'])[1]");

    public static By languages = By.xpath("(//span[contains(., 'Global (EN)')])[2]");
    public static By selectUkLanguage = By.xpath("(//a[@lang='uk'][contains(., 'Україна')])[2]");
    public static By ukLanguage = By.xpath("(//button[text()='Україна (UA)'])[1]");
    public static By policyLinks = By.xpath("//a[@class='fat-links']");
    public static By searchIcon = By.xpath("//span[contains(@class, 'search-icon')]");
    public static By inputSearchField = By.xpath("//input[@id='new_form_search']");
    public static By searchResult = By.xpath("//h2[contains(., $searchTerm)]");
    public static By contact = By.xpath("(//span[@class='cta-button__text'])[2]");
    public static By companyLogo = By.xpath("//a[@class=\"header__logo-container desktop-logo\"]");
    // demoWebShop locators
    // Fill in the registration form
    public static By firstNameField = By.xpath("//input[@id='FirstName']");
    public static By lastNameField = By.xpath("//input[@id='LastName']");
    public static By emailField = By.xpath("//input[@id='Email']");
    public static By passwordField = By.xpath("//input[@id='Password']");
    public static By confirmPasswordField = By.xpath("//input[@id='ConfirmPassword']");
    // Submit the registration form
    public static By registerButton = By.xpath("//input[@id='register-button']");
    public static By confirmRegistration = By.xpath("//div[@class='result' and contains(text(), 'Your registration completed')]");
    //User Login
    public static By userEmail = By.xpath("//input[@id='Email']");
    public static By userPass = By.xpath("//input[@id='Password']");
    public static By loginButton = By.xpath("//input[@value='Log in']");
    public static By logOutButton = By.xpath("//a[text() = 'Log out']");
    public static By computersPage = By.xpath("(//a[contains(text(), 'Computers')])[1]");
    public static By computersGroup = By.xpath("//a[contains(text(),'Computers')]");
    public static By computersSubGroups = By.xpath("//ul[@class='sublist']//li/a");
    public static By computersSortOrder = By.xpath("//select[@id='products-orderby']");
    public static By productTitle = By.xpath("//select[@id='products-orderby']/option[@selected]");
    public static By selectNumberPerPage = By.xpath("//select[@id='products-pagesize']");
    public static By numberPerPage = By.xpath("//select[@id='products-pagesize']/option[@selected]");
    public static By productGrid = By.xpath("//div[@class='product-grid']");
    public static By productItems = By.xpath("//div[@class='product-grid']//div[contains(@class, 'product-item')]");
    public static By addToCart = By.xpath("//input[@class='button-1 add-to-cart-button' and @value='Add to cart']");
    public static By shoppingCardItems = By.xpath("//span[@class='cart-qty']");
    public static By shoppingCard = By.xpath("//span[@class='cart-label'][.='Shopping cart']");
    public static By removeCheckBox = By.xpath("//input[@type='checkbox']");
    public static By updateCard = By.xpath("//input[contains(@class, 'update-cart-button')]");
    public static By emptyShoppingCart = By.xpath("//div[@class='order-summary-content']");
    public static By agreementCheckBox = By.xpath("//input[@name='termsofservice' and @type='checkbox']");
    public static By checkoutButton = By.xpath("//button[@type='submit' and @name='checkout']");
    public static By guestCheckoutButton = By.xpath("//input[@type='button' and @value='Checkout as Guest']");


}
