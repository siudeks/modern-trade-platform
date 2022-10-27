package com.crd.service.businessapigateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crd.service.businessapigateway.dto.PriceResponse;

/**
 * API Interface for the calculation service controller.
 */
public interface CalculationService {
  @RequestMapping(method = RequestMethod.GET, value = "/price")
  ResponseEntity<PriceResponse> getPrice();
}
