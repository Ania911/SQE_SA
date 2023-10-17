package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By title = By.xpath("//img[@alt='EPAM']");
    public static By modeToggle = By.xpath("(//div[@class='switch'])[2]");
    public static By lightMode = By.xpath("(//span[text()='Light Mode'])[1]");

    public static By languages = By.xpath("(//span[contains(., 'Global (EN)')])[2]");
    public static By selectUkLanguage = By.xpath("(//a[@lang='uk'][contains(., 'Україна')])[2]");
    public static By ukLanguage = By.xpath("(//button[text()='Україна (UA)'])[1]");



}
