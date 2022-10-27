Feature: Trade Service Tests

  Scenario: Should get the version of the trade service
    When I make a GET call on /trade/version
    Then I should receive 200 response status code
    And should receive a non-empty body

