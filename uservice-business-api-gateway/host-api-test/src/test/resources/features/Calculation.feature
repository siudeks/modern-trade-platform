Feature: Calculation Service Tests

  Scenario: Get a price from the calculation service
    When I make a GET call on /calculation/price
    Then I should receive 200 price response status code
    And should receive a non-empty price body
