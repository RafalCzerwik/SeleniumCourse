Feature: MyStore Address Management

  Scenario Outline: User can add first address

    Given a logged-in user with rafal.czerwik@testgmail.com and Rafal12345 is on the dashboard
    When user adding the first address with <alias> <streetName> <city> <postalCode> <phone>
    Then the address is added to the user account
    And the user checks if the provided data is correct

    Examples:
      | alias          | streetName            | city      | postalCode   | phone     |
      | "Main address" | "Street test 1"       | "Krakow"  | "01234"      | "123456789" |

#  Scenario: Deleting the added address for a user
#
#    Given a logged-in user with email "rafal.czerwik@testgmail.com" and password "Rafal12345" is on the dashboard
#    When the user deletes the recently added address
#    Then the address is deleted from the user's account
#    And the logged-in user checks if the address has been deleted