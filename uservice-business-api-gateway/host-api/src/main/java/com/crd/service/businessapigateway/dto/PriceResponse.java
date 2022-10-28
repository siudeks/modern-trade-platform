package com.crd.service.businessapigateway.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Response from price request.
 */
@Data
@Accessors(chain = true)
@ToString
public class PriceResponse {
  private double price;
}
