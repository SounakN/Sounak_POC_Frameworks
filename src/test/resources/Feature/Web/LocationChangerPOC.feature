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
    Examples:
      | location | Type       | Phone   | Model                      | Variant     | Header                        | HeaderInside                        | HeaderAfterSelection                              |
      | Kolkata  | Top Brands | Apple   | Apple iPhone 7             | 128 GB      | Sell Old Apple Mobile Phone   | Sell Old Apple iPhone 7             | Sell Old Apple iPhone 7 (2 GB/128 GB)             |
      | Kolkata  | Top Brands | Samsung | Samsung Galaxy S22 Plus 5G | 8 GB/256 GB | Sell Old Samsung Mobile Phone | Sell Old Samsung Galaxy S22 Plus 5G | Sell Old Samsung Galaxy S22 Plus 5G (8 GB/256 GB) |