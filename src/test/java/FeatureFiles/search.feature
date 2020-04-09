Feature: User is going to search for Vegetable and Proceed to Checkout
  Scenario: Search for Items and Validate the Results
    Given User  will navigate to the Website
    When  User searches for "Cucumber"
    Then  "Cucumber" result is displayed



  Scenario Outline: Search for items and then move to the checkOut
    Given User  will navigate to the Website
    When User searched for "<Name>" Vegetable
    And  Added items to the cart
    And  User proceed to the checkOut Page
    Then Verify selected "<Name>" items are displayed in the Checkout Page
    Examples:
      |Name|
      |Brinjal|
      |Beetroot|
      |Cucumber|



  @last
  Scenario: Add 2 or more items to the car and validate results
    Given User  will navigate to the Website
    When User added more than one item to the cart
    Then User proceed to the checkOut Page
    And  Verify selected items are displayed in the Checkout Page

