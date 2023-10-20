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

}
