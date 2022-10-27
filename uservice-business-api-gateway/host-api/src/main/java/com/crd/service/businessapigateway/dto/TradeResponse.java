package com.crd.service.businessapigateway.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Response from trade insertion.
 */
@Data
@Accessors(chain = true)
@ToString
public class TradeResponse {
  private String tradeId;
}
