Feature: Health check

  @todo
  Scenario: Should have a working health check
    When I make a GET call on /status
    Then I should receive 200 response status code
    And should receive a non-empty body

  Scenario: Test scenario
    When I run tests
    Then The response is 42
