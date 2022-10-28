package com.crd.service;

import org.springframework.stereotype.Service;

import com.crd.service.businessapigateway.CalculationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestCalculationService {
  private final CalculationService service;

  public int getPriceResponseCode() {
    return service.getPrice().getStatusCode().value();
  }

  public String getPriceResponse() {
    return service.getPrice().toString();
  }
}
