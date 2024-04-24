Feature: MyStore Address

  Scenario Outline: User can add address
    Given the user is on the main page
    And the user logs in to their account
    When the user navigates from the dashboard page to the addresses page
    And adds the first address with <alias> <streetName> <city> <postalCode> <phone>
    Then the address is added to the user's account
    And the user checks if the provided data is correct
    And close browser

    Examples:
      | alias          | streetName            | city      | postalCode   | phone     |
      | "Main address" | "Street test 1"       | "Krakow"  | "01234"      | "123456789" |