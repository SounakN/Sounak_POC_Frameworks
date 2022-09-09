Feature: Verify Session details
  As a user
  I  want to  login on student platform
  In order to verify the session details on the module card

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page
#    And User should skip tour modal

  @Web_SessionProgress @Web_LearnE2E
  Scenario: Verify Session details on the module card
    When User expands a module card
    Then User should see session details

  @Web_SessionProgress @Web_LearnE2E
  Scenario: Verify No of pages on the Session module
    When User expands a module card
    And User expands a session module
    Then User should see the number of pages in the session module