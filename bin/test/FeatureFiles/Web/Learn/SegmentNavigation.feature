Feature: Segment Navigation
  As a user
  I  want to login on student platform
  In order to navigate to the next or previous segment in a session

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page
#    And User should skip tour modal

  @Web_SegmentNavigation @Web_LearnE2E
  Scenario: Navigate to Next or Previous segment in a session by clicking on button navigation buttons
    When User expands a module card
    And User expands a session module
    And User opens a completed segment
    And User clicks on next segment button
    Then User should see next segment page
    And User clicks on previous segment button
    Then User should see previous segment page

  @Web_SegmentNavigation @Web_LearnE2E
  Scenario: Switch segments in a session by navigating through the side segment navigation
    When User expands a module card
    And User expands a session module
    And User opens a completed segment
    When User opens the side Navigation menu
    And User clicks on 2nd segment from the side navigation menu
    Then User should see next segment page
    When User opens the side Navigation menu
    And User clicks on 1st segment from the side navigation menu
    Then User should see previous segment page