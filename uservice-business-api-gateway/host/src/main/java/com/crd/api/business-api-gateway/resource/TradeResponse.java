package com.crd.api.businessapigateway.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Response from trade insertion.
 */
@Setter
@Getter
@AllArgsConstructor
public class TradeResponse {
  private String tradeId;
}
