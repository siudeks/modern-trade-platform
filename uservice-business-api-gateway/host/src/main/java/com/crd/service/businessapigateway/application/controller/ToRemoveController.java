package com.crd.service.businessapigateway.application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crd.service.businessapigateway.HelloService;
import com.crd.service.businessapigateway.application.service.TradeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
class ToRemoveController implements HelloService {

  private final TradeService tradeService;

  @Override
  public AskDto ask() {
    // ask remove service just to do some network call ...
    tradeService.getVersion();

    // ... and return some value to satisfy Gherkin tests
    return new AskDto().setValue(42);
  }
  
}
