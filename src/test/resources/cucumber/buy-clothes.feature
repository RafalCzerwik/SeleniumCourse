Feature: Purchase Hummingbird Printed Sweater

  Scenario: User purchases Hummingbird Printed Sweater
    Given a logged-in user with email rafal.czerwik@testgmail.com and password Rafal12345 is on the homepage
    When the user selects 5 items of Hummingbird Printed Sweater in size M and adds them to the cart
    Then the user goes through the entire checkout process until the order is finalized
    And takes a screenshot of the order confirmation with the total amount to be paid
    And close browser after