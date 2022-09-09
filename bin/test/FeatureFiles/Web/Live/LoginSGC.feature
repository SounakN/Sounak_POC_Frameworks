Feature: SGCLogin_Learner

  @SGCLogin_Learner_session
  Scenario: Login to the SGC platform
    Given User launches the "SGCUrl" URL
    When User enters Email Id "emailId"
    And User enters OTP "OTP"
    And Session details are checked



