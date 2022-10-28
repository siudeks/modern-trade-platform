package com.crd.service.businessapigateway.application.service.impl;

import com.crd.service.businessapigateway.application.model.Trade;
import com.crd.service.businessapigateway.application.service.TradeGrpcService;
import com.crd.service.businessapigateway.dto.Order;
import com.crd.service.businessapigateway.dto.TradeResponse;
import com.crd.common.grpc.TradeServiceGrpc;
import com.crd.common.grpc.TradeResources.CreateOrderRequest;

import io.grpc.ManagedChannel;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * Trade Enpoint implementation.
 */
@Slf4j
public class TradeGrpcServiceImpl implements TradeGrpcService {

  private final TradeServiceBlockingStub tradeService;
  private final AutoCloseable disposer;

  public TradeGrpcServiceImpl(ManagedChannel managedChannel) {
    this.managedChannel = managedChannel;
  }

  @Override
  public String getVersion() {
    log.info("Calling CRD Trade MicroService");

    var response = tradeService.getVersion(null);
    var version = response.getVersion();

    log.info("Received Version information from trade service, info {}", version);

    return version;
  }

  @Override
  public TradeResponse createNewOrder(Order order) {
    log.info("Calling CRD Trade MicroService with new order");
    log.info(order.toString());

    var orderRequest = CreateOrderRequest.newBuilder()
        .setCurrency(order.getCurrency())
        .setIndex(order.getIndex())
        .setMaturity(order.getMaturity())
        .setNotional(order.getNotional())
        .setTrader(order.getTrader())
        .setType(order.getType())
        .build();

    var tradeServiceApiBlockingStub = TradeServiceGrpc.newBlockingStub(managedChannel);
    var response = tradeServiceApiBlockingStub.postNewOrder(orderRequest);
    var tradeResponse = new TradeResponse().setTradeId(response.getTradeId());

    log.info("Received response from trade service, info {}", response.toString());
    log.info("Trade Service Response {}", tradeResponse.toString());

    return tradeResponse;
  }

  @Override
  public Trade getTrade(String tradeId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void close() throws Exception {
    disposer.close();
  }
}
