package com.crd.service;

import org.assertj.core.api.Assertions;

import io.cucumber.java.en.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TradeTests {

  private final TestTradeService tradeService;

  @When("I make a GET call on \\/trade\\/version")
  public void i_make_a_get_call_on_trade_version() {
    // nothing yet
  }

  @Then("I should receive {int} response status code")
  public void i_should_receive_response_status_code(Integer int1) {
    var result = tradeService.getVersionResponseCode();
    Assertions.assertThat(result).isEqualTo(int1);
  }

  @Then("should receive a non-empty body")
  public void should_receive_a_non_empty_body() {
    var result = tradeService.getVersionResponse();
    Assertions.assertThat(result).isNotEmpty();
  }
}
