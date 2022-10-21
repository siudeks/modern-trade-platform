package com.crd.service.businessapigateway.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crd.service.businessapigateway.application.service.CalculationService;
import com.crd.service.businessapigateway.resource.PriceResponse;

/**
 * Controller for Calculation operations.
 */
@RestController
@RequestMapping(value = "/calculation")
public class CalculationServiceController {
  @Autowired
  private CalculationService calculationService;

  /**
   * Price endpoint.
   */
  @GetMapping("/price")
  public ResponseEntity<PriceResponse> getPrice() {
    var price = calculationService.getPrice();
    var priceResponse = new PriceResponse(price);
    return new ResponseEntity<>(priceResponse, HttpStatus.OK);
  }
}
