Feature: Application Flow
  As a user, I want to apply to an upgrad program via old flow
  Background:
    Given User launches the Staging URL "StagingURL"
    When User clicks on SIGNUP button
    Then User enters credentials "EmailId" and "OTP"
    Then Verify user SignUp Successfully

  @web_marketing_P0_dweb @web_marketing_P0_mweb @web_marketing_P0_feature4_scenario1
  Scenario Outline: Apply for all old courses as a signed up user and check status of application, from header link
    When user visits "<linkname>" program page via direct url
    And user starts the application using the apply now button in the  course-desc section
    And user completes course "<linkname>" application
    Then Verify application is submitted successfully
    And status for the program "<linkname>" becomes "<Status>"

    Examples:
      | linkname               | Status  |
      | data-science-pgd-iiitb | Applied |

  @web_marketing_P0_dweb @web_marketing_P0_mweb @web_marketing_P0_feature4_scenario2
  Scenario Outline: Apply for all New  courses as a signed up user and check status of application, from header link
    When user visits "<linkname>" program page via direct url for NewApplication
    And user starts the application using the apply now button in the  course-desc section for NewApplication
    Then User fill the form of the application "<linkname>"
    Then Verify application is submitted successfully for NewApplication
    And status for the program "<linkname>" becomes "<Status>"

    Examples:
      | linkname                 | Status      |
      | design-thinking-duke-ce/ | SHORTLISTED |
