package com.crd.service.businessapigateway.application.service;

import com.crd.service.businessapigateway.application.model.Order;
import com.crd.service.businessapigateway.application.model.Trade;
import com.crd.service.businessapigateway.resource.TradeResponse;

/**
 * Trade REST Service Interface.
 */
public interface TradeService {
  String getVersion();

  TradeResponse createNewOrder(Order order);

  Trade getTrade(String tradeId);
}
