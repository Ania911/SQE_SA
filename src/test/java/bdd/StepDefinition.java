package bdd;

import core.assertion.Assertion;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Locators;
import org.testng.annotations.AfterTest;
import pages.MainPage;
import tests.BaseTest;

public class StepDefinition extends BaseTest {

    private MainPage openPage;
    private Assertion assertion;
    @Before
    public void setUp() {
        // Initialize WebDriver and other setup in the BaseTest class
        super.setUpClass();
        openPage = new MainPage(driver);
        assertion = new Assertion(openPage);

    }

    @Given("user opens main page")
    public void user_opens() {
        openPage = new MainPage(driver);
    }

    @Then("the title should be equal {string}")
    public void the_title_should_be_equal(String expectedTitle) {
        assertion.assertAttributePresent(Locators.title, expectedTitle, "Element not found");
    }

    @When("user switches the toggle for the theme to opposite state")
    public void user_switches_toggle() {
       openPage.switchToggle();
    }

    @Then("the theme should be changed to {string}")
    public void the_theme_should_be_changed_to(String expectedTitle) {
        assertion.assertTextPresent(Locators.lightMode, expectedTitle, "Element not found");
    }

    @When("user switches the language to Ukraine")
    public void user_switches_the_language_to_ukraine() {
        openPage.changeLanguage();
    }

    @Then("the sites context should be changed to {string}")
    public void the_sites_context_should_be_changed_to(String expectedTitle) {
        assertion.assertTextPresent(Locators.ukLanguage, expectedTitle, "Element not found");
    }

   @After
    public void tearDown() {
        driver.quit();
    }

}

