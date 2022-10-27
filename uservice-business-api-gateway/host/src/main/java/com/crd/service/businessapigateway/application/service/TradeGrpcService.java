package com.crd.service.businessapigateway.application.service;

import com.crd.service.businessapigateway.application.model.Trade;
import com.crd.service.businessapigateway.dto.Order;
import com.crd.service.businessapigateway.dto.TradeResponse;

/**
 * Trade REST Service Interface.
 */
public interface TradeGrpcService {
  String getVersion();

  TradeResponse createNewOrder(Order order);

  Trade getTrade(String tradeId);
}
