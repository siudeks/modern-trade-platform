package com.crd.api.businessApiGateway.application.service;

import com.crd.api.businessApiGateway.application.model.Trade;

public interface TradeService {
    String getVersion();
    String createNewTrade(Trade trade);
    Trade getTrade(String tradeId);
}
