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
  Scenario Outline: User chooses location from given choice
    Given User launches the "URL" and verifies landing on homePage
    Then User can change the Location to "<location>"
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
    Examples:
      | location | Type       | Phone   | Model                      | Variant     | Header                        | HeaderInside                        | HeaderAfterSelection                              |
      | Kolkata  | Top Brands | Apple   | Apple iPhone 7             | 128 GB      | Sell Old Apple Mobile Phone   | Sell Old Apple iPhone 7             | Sell Old Apple iPhone 7 (2 GB/128 GB)             |
      #| Kolkata  | Top Brands | Samsung | Samsung Galaxy S22 Plus 5G | 8 GB/256 GB | Sell Old Samsung Mobile Phone | Sell Old Samsung Galaxy S22 Plus 5G | Sell Old Samsung Galaxy S22 Plus 5G (8 GB/256 GB) |