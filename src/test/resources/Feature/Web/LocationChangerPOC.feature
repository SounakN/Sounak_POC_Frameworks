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
    Examples:
      | location  |
      | Kolkata   |