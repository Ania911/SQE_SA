Feature: User Story 1234567: Supporting EPAM.com
  As a QA
  I want to be sure that all main functionality works correctly
  So that I need to have full regression coverage

  Background:
    Given user opens main page

#  @ui_web @priority_medium @automated @regression
#  Scenario: Verify Correct Title
#    Then the title should be equal "EPAM"

#  @ui_web @priority_medium @automated @regression
#  Scenario: Verify Ability to Switch Light/Dark Mode
#    When user switches the toggle for the theme to opposite state
#    Then the theme should be changed to "Light Mode"

  @ui_web @priority_medium @automated @regression
  Scenario: Verify Language Change to Ukrainian (UA)
    When user switches the language to Ukraine
    Then the sites context should be changed to "Україна (UA)"
#
#  @ui_web @priority_medium @not_automated @regression
#  Scenario: Verify Policies List
#    When user scrolls to the bottom of the page
#    Then the policies list should include the following items:
#      | INVESTORS                |
#      | COOKIE POLICY            |
#      | OPEN SOURCE              |
#      | APPLICANT PRIVACY NOTICE |
#      | PRIVACY POLICY           |
#      | WEB ACCESSIBILITY        |
#
#  @ui_web @priority_medium @not_automated @regression
#  Scenario: Verify Ability to Switch Location List by Region
#    When user gos to the "Our Locations" section
#    Then 3 regions should be presented:
#      | AMERICAS |
#      | EMEA     |
#      | APAC     |
#    And it allows me to switch the regions locations list
#
#  @ui_web @priority_medium @not_automated @regression
#  Scenario: Verify Search Functionality
#    When user opens the search field and submit the request "AI"
#    Then the site should show the search result
#
#  @ui_web @priority_medium @not_automated @regression
#  Scenario: Verify Form Fields Validation
#    When user checks validation for required fields
#    Then required fields should be marked as required
#
#  @ui_web @priority_medium @not_automated @regression
#  Scenario: Verify Company Logo Leads to Main Page
#    When user clicks on the company logo on the header
#    Then "https://www.test.com/" page should be opened
#
#  @ui_web @priority_medium @not_automated @regression
#  Scenario: Verify Ability to Download Report
#    When user downloads Test Corporate Overview 2023 report on "test at a Glance" block
#    Then the files should be downloaded with the correct name and extension
