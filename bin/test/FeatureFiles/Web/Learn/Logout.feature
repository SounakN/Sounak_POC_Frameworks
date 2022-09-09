Feature: Logout on lite platform
  As a User
  I  want to  login on student platform
  In order to test logout flow

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page
#    And User should skip tour modal

  @Web_Logout @Web_LearnE2E
  Scenario: Verify logout
    When logged in User select logout on my profile menu
    Then User should see login page