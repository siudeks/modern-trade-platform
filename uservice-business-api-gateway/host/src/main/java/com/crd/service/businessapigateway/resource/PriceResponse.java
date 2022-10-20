package com.crd.service.businessapigateway.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Response from price request.
 */
@Setter
@Getter
@AllArgsConstructor
public class PriceResponse {
  private double price;
}
