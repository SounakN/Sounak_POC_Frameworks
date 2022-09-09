Feature: International Payments Page Components and its functionality Validation

  Background: SignUp user and shortlist the program
    Given User launches the Staging URL "StagingURL"
    When User clicks on SIGNUP button
    Then User enters credentials "EmailId" and "OTP"
    Then Verify user SignUp Successfully

  @web_marketing_prod_P0_desktop @web_marketing_prod_P0_mobile @check1234
  Scenario Outline: Verify International Payment page components and payment methods of specific program
    When user visits "<Program_Name>" program page via direct url for NewApplication
    And user starts the application using the apply now button in the  course-desc section for NewApplication
    And User navigates to "My applications" page
    When "SHORTLISTED" user lands on payment page of Program_Name by clicking on "Make Payment"
    Then User verifies all the components on payments page
      |    Components         |
      |   Total Course Fees   |
      |   Your course:        |
      |   1. Payment Options  |
      |   2. Billing Details  |
      |   SUMMARY             |
    And Payment page has all types of International payment methods its options
      |    PaymentMethods     |
      |    Pay upfront        |
      |    Reserve a seat     |

    Examples:
      |           Program_Name               |
#      | us/design-thinking-duke-ce/          |
      | us/business-analytics-certification  |

  @web_marketing_prod_P0_desktop @web_marketing_prod_P0_mobile @check1234
  Scenario Outline: Verify the Part and Full Payment functionalities by using different International payment methods
    When user visits "<Program_Name>" program page via direct url for NewApplication
    And user starts the application using the apply now button in the  course-desc section for NewApplication
    And User navigates to "My applications" page
    When "SHORTLISTED" user lands on payment page of Program_Name by clicking on "Make Payment"
    And User enters part payment amount by selecting "<Payment_Method>"
    When User clicks on next button
    Then User observes that the paying amount adjusted correctly under Summary section for International payment
    And User should also see the billing details section along with "<Payment_Method>" selected
    When User fills the billing details and clicks on next button
      | LastName | Address  |   PinCode   |              City               |
      | AutoUser |  Newark  |   07101     | Newark,New Jersey,United States |
    And User selects Terms Of Use checkbox
    When User selects "<Payment_Mode>" and enters payment details
    |     CardNumber    |  ExpDate |  CVV  | NameOnCard|
    |3700 0000 0000 002 |  03/30   | 7373  |  James    |
    And User clicks on Pay button
    Then User observes payment success message and navigates to applications page "AppPageURL"
    And User should see the Application Status of the program is updated as "<Payment_Status>"
    Examples:
      |          Program_Name                 | Payment_Method |     Payment_Mode       | Payment_Status |
      | us/business-analytics-certification   | Reserve a seat |  Credit or debit card  |  PART_PAYMENT  |
      | us/business-analytics-certification   | Pay upfront    |  Credit or debit card  |  PAID          |
