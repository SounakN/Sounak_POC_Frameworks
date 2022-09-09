Feature: Try to post a question on the discussion tab
  As a user
  I  want to  login on student platform
  In order to post a question on the discussion page

  Background:
    Given User launches the "learnUrl" site
    When User enters "email" and "password"
    And User clicks on login button
    Then Choose a program page should be displayed
    When User selects first course
    Then User should see Home page

  @Web_DiscussionTab @Web_LearnE2E
  Scenario: Post question on discussion tab
    When User clicks on discussion tab
    Then Skill section should be visible
    And User should skip skill section
    Then Discussion page should be visible
    When User enters "question" in search area
    And User clicks on Ask button
    When User enters "description" in the text area
    And User clicks on select topic button
    Then Select topic search box should be visible
    And User selects a topic from the search box
    And User clicks on Post button
    Then User should be able to see the posted "question"