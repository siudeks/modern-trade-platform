package com.crd.service.businessapigateway.application.service.impl;

import org.springframework.stereotype.Service;

import com.crd.common.grpc.CalculationServiceGrpc;
import com.crd.common.grpc.CalculationServiceGrpc.CalculationServiceBlockingStub;
import com.crd.service.businessapigateway.application.config.Closeable;
import com.crd.service.businessapigateway.application.service.CalculationGrpcService;

import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Calculation Enpoint implementation.
 */
@Service
@Slf4j
public class CalculationGrpcServiceImpl implements CalculationGrpcService {

  private final CalculationServiceBlockingStub calculationService;

  public CalculationGrpcServiceImpl(Closeable.Of<ManagedChannel> calculationManagedChannel) {
    var channel = calculationManagedChannel.item();
    calculationService = CalculationServiceGrpc.newBlockingStub(channel);
  }
  
  @Override
  public double getPrice() {
    log.info("Calling CRD Calculation MicroService");

    //var priceRequest = new PriceRequest()
    var response = calculationService.getPrice(null);
    var price = response.getPrice();

    log.info("Received Price from calculation service, Price = '{}'", price);

    return price;
  }
  
}
