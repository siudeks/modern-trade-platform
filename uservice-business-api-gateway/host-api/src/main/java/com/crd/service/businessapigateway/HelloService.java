package com.crd.service.businessapigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Data;
import lombok.experimental.Accessors;

/** Example API contract to run simple Gherkin scenario. */
public interface HelloService {
  
  @RequestMapping(method = RequestMethod.GET, value = "/ask")
  AskDto ask();

  /** Result of {@link HelloService#ask()}. */
  @Data
  @Accessors(chain = true)
  class AskDto {
    private int value;
  }
}
