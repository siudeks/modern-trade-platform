package com.crd.service.businessapigateway.application.service.impl;

import com.crd.common.grpc.TradeResources.CreateOrderRequest;

import java.util.concurrent.TimeUnit;

import com.crd.common.grpc.TradeServiceGrpc;
import com.crd.common.grpc.TradeServiceGrpc.TradeServiceBlockingStub;
import com.crd.service.businessapigateway.application.model.Order;
import com.crd.service.businessapigateway.application.model.Trade;
import com.crd.service.businessapigateway.application.service.TradeService;
import com.crd.service.businessapigateway.resource.TradeResponse;

import io.grpc.ManagedChannel;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * Trade Enpoint implementation.
 */
@Slf4j
public class TradeServiceImpl implements TradeService, AutoCloseable {

  private final TradeServiceBlockingStub tradeService;
  private final AutoCloseable disposer;

  /** Default constructor with assumption of the give channel is owned by the created instance. */
  public TradeServiceImpl(ManagedChannel ownedChannel) {
    tradeService = TradeServiceGrpc.newBlockingStub(ownedChannel);
    disposer = () -> {
      ownedChannel.shutdown();
      val someTimeoutForGrpcChannel = 3;
      ownedChannel.awaitTermination(someTimeoutForGrpcChannel, TimeUnit.SECONDS);
    };
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

    var response = tradeService.postNewOrder(orderRequest);
    var tradeResponse = new TradeResponse(response.getTradeId());

    log.info("Received response from trade service, info {}", tradeResponse);
    log.info("Trade Service Response {}", tradeResponse);

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
