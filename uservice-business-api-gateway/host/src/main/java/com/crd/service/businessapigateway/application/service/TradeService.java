package com.crd.service.businessapigateway.application.service;

import com.crd.service.businessapigateway.application.model.Trade;

/**
 * Trade REST Service Interface.
 */
public interface TradeService {
  String getVersion();

  String createNewTrade(Trade trade);

  Trade getTrade(String tradeId);
}
