Feature: Switch Course/Program from the choose program page
  As a user
  I  want to  login on student platform
  In order to select my course from the course selection page

  Background:
    Given User launches the "learnUrl" site

  @Web_ChooseProgram @Web_LearnE2E
  Scenario: Login to choose program
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page