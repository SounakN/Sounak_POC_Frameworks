Feature: Login as a student and to continue to learn
  As a User
  I  want to  login on student platform
  In order to continue learning from where we left

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page
#    And User should skip tour modal

  @Web_ContinueLearning @Web_LearnE2E
  Scenario: Verifying active continue learning CTA on session tile
    When User expands a module card
    And User clicks on continue learning CTA on session tile
    Then User should land on current segment