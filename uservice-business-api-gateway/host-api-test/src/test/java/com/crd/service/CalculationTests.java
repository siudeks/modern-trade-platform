package com.crd.service;

import org.assertj.core.api.Assertions;

import io.cucumber.java.en.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CalculationTests {

  private final TestCalculationService calculationService;

  @When("I make a GET call on \\/calculation\\/price")
  public void i_make_a_get_call_on_calculation_price() {
    // nothing yet
  }

  @Then("I should receive {int} price response status code")
  public void i_should_receive_price_response_status_code(Integer int1) {
    var result = calculationService.getPriceResponseCode();
    Assertions.assertThat(result).isEqualTo(int1);
  }

  @Then("should receive a non-empty price body")
  public void should_receive_a_non_empty_price_body() {
    var result = calculationService.getPriceResponse();
    Assertions.assertThat(result).isNotEmpty();
  }
}
