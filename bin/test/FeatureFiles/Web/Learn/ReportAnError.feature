Feature: Report an error on segment page
  As a User
  I  want to login on student platform
  In order to report an error on segment page

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page
    And User should skip tour modal

  @Web_LearnE2E @Web_Report_an_error
  Scenario: Verify report an error for technical error type
    When User choose any segment on home page
    And report an error for technical error type "reportAnErrorText"
    Then User should see successful or unsuccessful message

  @Web_LearnE2E @Web_Report_an_error
  Scenario: Verify report an error for overall content error type
    When User choose any segment on home page
    And report an error for overall content error type "reportAnErrorText"
    Then User should see successful or unsuccessful message