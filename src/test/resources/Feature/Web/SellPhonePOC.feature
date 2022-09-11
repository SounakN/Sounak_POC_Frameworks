Feature: User can Sell a Phone



  @locationchoice
  Scenario Outline: User chooses location from given choice
    Given User launches the "URL" and verifies landing on homePage
    Then User can change the Location to "<location>"

    Examples:
      | location  |
      | Kolkata   |