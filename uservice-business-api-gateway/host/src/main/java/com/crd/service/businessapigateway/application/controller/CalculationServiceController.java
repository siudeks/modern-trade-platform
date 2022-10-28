package com.crd.service.businessapigateway.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crd.service.businessapigateway.CalculationService;
import com.crd.service.businessapigateway.application.service.CalculationGrpcService;
import com.crd.service.businessapigateway.dto.PriceResponse;

import lombok.RequiredArgsConstructor;

/**
 * Controller for Calculation operations.
 */
@RestController
@RequestMapping(value = "/calculation")
@RequiredArgsConstructor
class CalculationServiceController implements CalculationService {
  
  private final CalculationGrpcService calculationService;

  /**
   * Price endpoint.
   */
  @Override
  public ResponseEntity<PriceResponse> getPrice() {
    var price = calculationService.getPrice();
    var priceResponse = new PriceResponse().setPrice(price);
    return new ResponseEntity<>(priceResponse, HttpStatus.OK);
  }
}
