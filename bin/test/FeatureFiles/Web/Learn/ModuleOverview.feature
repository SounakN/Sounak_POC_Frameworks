Feature: Verify the selected module details on the module card
  As a user
  I  want to  login on student platform and select a module from module overview
  In order to verify the selected module details on the module card

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page
#    And User should skip tour modal

  @Web_ModuleOverview @Web_LearnE2E
  Scenario: Verify the selected module details on the module card
    When User selects a module from module overview
    Then User should see module details