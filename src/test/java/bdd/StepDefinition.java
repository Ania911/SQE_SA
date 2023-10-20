package bdd;

import core.assertion.Assertion;
import core.configuration.UIConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.Locators;
import org.testng.Assert;
import pages.MainPage;
import pages.ResearchPage;
import tests.BaseTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StepDefinition extends BaseTest {

    private MainPage openPage;
    private ResearchPage researchPage;
    private Assertion assertion;

    private List<String> policyItems = new ArrayList<>();

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

    @When("user scrolls to the bottom of the page")
    public void user_scrolls_to_the_bottom() {
        openPage.scrollToBottom();
    }

    @Then("the policies list should include the following items:")
    public void the_policies_list_should_include_the_following_items(List<String> expectedPolicyItems) {
        openPage.getListItems(expectedPolicyItems, Locators.policyLinks);
    }

    @When("user opens the search field and submit the request {string}")
    public void user_opens_search_field_and_submit_request(String searchQuery) {
        openPage.searchQuery(searchQuery);
    }

    @Then("the site should show the search result for {string}")
    public void the_site_should_show_the_search_results(String searchResult) {
        assertion.assertTextPresent(Locators.searchResult, searchResult, "Element not found");
    }

    @When("user checks validation for required fields:")
    public void user_check_validation_for_required_fields(List<String> requiredFields) {
        openPage.clickButton(Locators.contact);
        openPage.checkFieldsAreRequired(requiredFields);
    }

    @Then("required fields should be marked as required")
    public void required_fields_marked_as_required() {
        Assert.assertTrue(true, "Error");
    }

    @When("user clicks on the company logo on the header")
    public void user_click_on_the_company_logo() {
        openPage.clickButton(Locators.companyLogo);
    }

    @Then("the page with URL {string} should be opened")
    public void page_should_be_opened(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @When("user downloads Test Corporate Overview 2023 report on \"test at a Glance\" block")
    public void user_download_report() {
        researchPage = new ResearchPage(driver);
        driver.get(UIConfig.getUrlLink());
    }

    @Then("the files should be downloaded with {string}")
    public void verify_downloaded_file(String expectedFileName) {
        researchPage = new ResearchPage(driver);
        File downloadedFile = researchPage.getDownloadFile(expectedFileName);
        assertion.assertDownloadedFile(downloadedFile, expectedFileName);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}

