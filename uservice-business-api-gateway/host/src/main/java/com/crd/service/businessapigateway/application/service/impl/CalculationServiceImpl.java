package com.crd.service.businessapigateway.application.service.impl;

import com.crd.common.grpc.CalculationServiceGrpc;
import com.crd.service.businessapigateway.application.service.CalculationService;

import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * Calculation Enpoint implementation.
 */
@Slf4j
public class CalculationServiceImpl implements CalculationService {

  private ManagedChannel managedChannel;

  public CalculationServiceImpl(ManagedChannel managedChannel) {
    this.managedChannel = managedChannel;
  }

  @Override
  public double getPrice() {
    log.info("Calling CRD Calculation MicroService");

    var calculationServiceApiBlockingStub = CalculationServiceGrpc.newBlockingStub(managedChannel);
    //var priceRequest = new PriceRequest()
    var response = calculationServiceApiBlockingStub.getPrice(null);
    var price = response.getPrice();

    log.info("Received Price from calculation service, Price = '{}'", price);

    return price;
  }
  
}
