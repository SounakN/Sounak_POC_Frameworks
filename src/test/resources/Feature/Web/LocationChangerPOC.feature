Feature: User can choose Location

  @locationchoice
  Scenario Outline: User chooses location from given choice
    Given User launches the "URL" and verifies landing on homePage
    Then User can change the Location to "<location>"

    Examples:
      | location  |
      | Kolkata   |
      | Mumbai    |
      | Bangalore |
      | Delhi     |

  @SellPhone
  Scenario Outline: User Sells a phone
    Given User launches the "URL" and verifies landing on homePage
    Then User can change the Location to "<location>"
    And User logs in with the Number "PhoneNumber" and OTP "Test_OTP"
    And User chooses "Sell Phone" from navigation Header
      | Type   | Phone   |
      | <Type> | <Phone> |
    Then User Selects the Phone Model and variant
      | Model   | Variant   | Header   | HeaderInside   | HeaderAfterSelection   |
      | <Model> | <Variant> | <Header> | <HeaderInside> | <HeaderAfterSelection> |
    And User gets Exact Value by answering Questionnaires
      | Questions                                          | Answers |
      | 1. Are you able to make and receive calls?         | Yes     |
      | 2. Is your device's touch screen working properly? | Yes     |
      | 3. Is your phone's screen original?                | Yes     |
      | 4. Is your device under brand warranty?            | No      |
      | 5. Do you have valid bill with same IMEI?          | Yes     |
    Then User checks all those available options for the Phone
    Then User provides the Contact Information for selling
      | days | slots | paymentMethod | furtherActivity |
      | 1    | 0     | Upi           | Order Details   |
    Then continue with Order Details
      | activity     | reason             |
      | Cancel Order | Gave it to someone |
    Examples:
      | location | Type       | Phone   | Model                      | Variant     | Header                        | HeaderInside                        | HeaderAfterSelection                              |
      | Kolkata  | Top Brands | Apple   | Apple iPhone 7             | 128 GB      | Sell Old Apple Mobile Phone   | Sell Old Apple iPhone 7             | Sell Old Apple iPhone 7 (2 GB/128 GB)             |
      | Kolkata  | Top Brands | Samsung | Samsung Galaxy S22 Plus 5G | 8 GB/256 GB | Sell Old Samsung Mobile Phone | Sell Old Samsung Galaxy S22 Plus 5G | Sell Old Samsung Galaxy S22 Plus 5G (8 GB/256 GB) |

  @BuyPhone
  Scenario Outline: User Buys a phone
    Given User launches the "URL" and verifies landing on homePage
    Then User can change the Location to "<location>"
    And User chooses "Buy Phone" from navigation Header
      | Type   | Phone   |
      | <Type> | <Phone> |
    Then User Selects the Phone from the available list
      | Model   |
      | <Model> |
    Then User provides the Contact Information
      | Email                | First name | Last name | Address    | City    | State | PIN code | Phone      |
      | sounak@codevyasa.com | SS         | NN        | HaridasPur | Kolkata | WB    | 700000   | 9999999999 |
    And Validates the information present on screen
      | Email                | Address    | City    | State | PIN code |
      | sounak@codevyasa.com | HaridasPur | Kolkata | WB    | 700000   |


    Examples:
      | location | Type       | Phone   | Model                            |
      | Kolkata  | Top Brands | Apple   | Apple iPhone X - Refurbished     |
      | Kolkata  | Top Brands | Samsung | Samsung Galaxy A12 - Refurbished |


