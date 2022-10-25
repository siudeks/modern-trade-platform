package com.crd.service.businessapigateway.application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crd.service.businessapigateway.HelloService;

@RestController
class ToRemoveController implements HelloService {

  @Override
  public AskDto ask() {
    return new AskDto().setValue(42);
  }
  
}
