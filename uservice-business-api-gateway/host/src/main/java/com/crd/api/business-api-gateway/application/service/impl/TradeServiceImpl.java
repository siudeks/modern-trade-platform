package com.crd.api.businessapigateway.application.service.impl;

import com.crd.api.businessapigateway.application.model.Trade;
import com.crd.api.businessapigateway.application.service.TradeService;
import com.crd.common.grpc.TradeServiceGrpc;

import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Trade Enpoint implementation.
 */
@Slf4j
public class TradeServiceImpl implements TradeService {

  private ManagedChannel managedChannel;

  public TradeServiceImpl(ManagedChannel managedChannel) {
    this.managedChannel = managedChannel;
  }

  @Override
  public String getVersion() {
    log.info("Calling CRD Trade MicroService");

    var tradeServiceApiBlockingStub = TradeServiceGrpc.newBlockingStub(managedChannel);
    var response = tradeServiceApiBlockingStub.getVersion(null);
    var version = response.getVersion();

    log.info("Received Version information from trade service, info {}", version);

    return version;
  }

  @Override
  public String createNewTrade(Trade trade) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Trade getTrade(String tradeId) {
    // TODO Auto-generated method stub
    return null;
  }
}
