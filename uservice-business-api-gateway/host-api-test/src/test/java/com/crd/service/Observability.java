package com.crd.service;

import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;

import io.cucumber.java.en.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Observability {

  private final MyService myService;

  @When("I run tests")
  public void i_run_tests() {
    // nothing yet
  }

  @Then("The response is {int}")
  public void the_response_is(Integer expected) {
    var result = myService.askMe();
    Assertions.assertThat(result).isEqualTo(expected);
  }
}
