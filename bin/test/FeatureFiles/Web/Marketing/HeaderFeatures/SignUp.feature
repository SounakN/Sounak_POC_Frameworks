Feature: Signup and Leads Flow
  As an user, I want to signup via different CTAs from Homepage

  Background:
    Given User launches the Staging URL "StagingURL"
    Then Verify user Navigate to Homepage Successfully

  @HomePage_SignUp_TopNav @signUp
  Scenario: Verify Signup via top nav [SIGNUP button]

    When User clicks on SIGNUP button
    Then User enters credentials "EmailId" and "OTP"
    Then Verify user SignUp Successfully

  @HomePage_SignUp_CareerHandbook @signUpt
  Scenario: Verify SignUp via Get Career Handbook

    When User clicks on CareerHandbook button
    Then User enters credentials "EmailId" and "OTP"
    Then Verify user SignUp Successfully
