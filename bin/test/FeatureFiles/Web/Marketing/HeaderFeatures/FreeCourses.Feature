Feature: Free Courses
  As a user, I want to signup via Register in free Courses and Verify-in LeadSquare

  @web_marketing_staging @fressCources
    Scenario Outline: Verify Free Course CTA in lead square
    Given User launches the Staging URL "StagingURL"
    Then User click on view all free courses button and navigate to free courses window and click on Register for "<FreeCourses>"
    Then User enters the credentials
    Then verify user signUp Successfully
    Then Verify user navigate to Learning Platform Page
    And Lead is created in the lead sqaure portal for "<ProgramOfInterest>"
    Examples:
      | FreeCourses                            | ProgramOfInterest    |
      | Getting Started with Digital Marketing | fc-digital-marketing |





