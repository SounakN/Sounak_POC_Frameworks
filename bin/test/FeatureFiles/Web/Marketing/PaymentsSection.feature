Feature: Payments Page Components and its functionality Validation

  Background: SignUp user and shortlist the program
    Given User launches the Staging URL "StagingURL"
    When User clicks on SIGNUP button
    Then User enters credentials "EmailId" and "OTP"
    Then Verify user SignUp Successfully

  @web_marketing_prod_P0_desktop @web_marketing_prod_P0_mobile @check
  Scenario Outline: Verify Payment page components and payment methods for all programs
    When user visits "<Program_Name>" program page via direct url for NewApplication
    And user starts the application using the apply now button in the  course-desc section for NewApplication
    And User navigates to "My applications" page
    When "SHORTLISTED" user lands on payment page of Program_Name by clicking on "Make Payment"
    Then User verifies all the components on payments page
      |    Components         |
      |   Start learning from |
      |   Your course:        |
      |   1. Payment Options  |
      |   2. Billing Details  |
      |   SUMMARY             |
    And Payment page has all types of payment methods its options
      |    PaymentMethods     |                 PaymentOptions                    |
      |    Recommended        |  NO COST CREDIT CARD EMI:NO COST CARDLESS EMI     |
      |    Pocket-Friendly    |  STANDARD CREDIT CARD EMI:STANDARD CARDLESS EMI   |
      |    Reserve a Seat     |  Credit / Debit Card:Net Banking:UPI              |
      |    Other options      |  Credit / Debit Card:Net Banking                  |

    Examples:
      |          Program_Name            |
      | mba-digital-finance-jgu-pp       |

  @web_marketing_prod_P0_desktop @web_marketing_prod_P0_mobile @check
  Scenario Outline: Verify the Part and Full Payment functionalities  by using Net Banking payment method
    When user visits "<Program_Name>" program page via direct url for NewApplication
    And user starts the application using the apply now button in the  course-desc section for NewApplication
    And User navigates to "My applications" page
    When "SHORTLISTED" user lands on payment page of Program_Name by clicking on "Make Payment"
    And User enters "<Payment_Type>" amount by selecting "<Payment_Mode>" under "<Payment_Method>"
    Then User observes that the paying amount adjusted correctly under Summary section for "<Payment_Type>"
    And User clicks on next button
    When User selects "<Bank_Name>" and click on next button
    Then User should see the billing details section along with "<Payment_Mode>","<Bank_Name>" selected
    And User fills the billing details and clicks on next button
      |   Address  |   PinCode   |           City                |
      | Hyderabad  |   500001    | Hyderabad,Telangana,India   |
    When User selects Terms Of Use checkbox and clicks on Make Payment button
    Then User should see Razorpay payment gateway page along with Success and Failure buttons
    And User clicks on Success button
    When User observes payment success message and navigates to applications page "AppPageURL"
    And User should see the Application Status of the program is updated as "<Payment_Status>"
    #Bank Names :  "HDFC Bank", "Yes Bank", "ICICI Bank", "Axis Bank"
    Examples:
      |         Program_Name        | Payment_Type             | Payment_Method | Payment_Mode  |Bank_Name     |Payment_Status|
      | mba-digital-finance-jgu-pp  | SHORTLISTED,PART_PAYMENT | Reserve a Seat |  Net Banking  | HDFC Bank    |PART_PAYMENT  |
      | mba-digital-finance-jgu-pp  | SHORTLISTED,FULL_PAYMENT | Reserve a Seat |  Net Banking  | HDFC Bank    |PART_PAYMENT  |
