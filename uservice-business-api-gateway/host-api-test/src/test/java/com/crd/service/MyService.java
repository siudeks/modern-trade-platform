package com.crd.service;

import org.springframework.stereotype.Service;

import com.crd.service.businessapigateway.HelloService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyService {
  
  private final HelloService service;

  public int askMe() {
    return service.ask().getValue();
  }
}
