package com.crd.service;

import org.springframework.stereotype.Service;

import com.crd.service.businessapigateway.TradeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestTradeService {
  private final TradeService service;

  public int getVersionResponseCode() {
    return service.version().getStatusCode().value();
  }

  public String getVersionResponse() {
    return service.version().toString();
  }
}
