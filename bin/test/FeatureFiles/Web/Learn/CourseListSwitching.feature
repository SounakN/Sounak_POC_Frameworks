Feature: Login as a student and select a course from the course dropdown
  As a user
  I  want to login to the student platform
  In order to select a course from the course dropdown

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page
#    And User should skip tour modal

  @Web_CourseListSwitching @Web_LearnE2E
  Scenario: Verify the course dropdown and change the module group from it
    When User selects course from course dropdown
    Then User should be able to change course from list
