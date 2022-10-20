package com.crd.service.calculationservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crd.common.grpc.CalculationServiceGrpc;
import com.crd.common.grpc.CalculationResources.PriceRequest;
import com.crd.common.grpc.CalculationResources.PriceResponse;
import com.crd.service.calculationservice.processor.PricingProcessor;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * GRPC API for Trade Service Functionality.
 */
@Slf4j
@Component
public class CalculationApiService extends CalculationServiceGrpc.CalculationServiceImplBase {
  @Autowired
  private PricingProcessor pricingProcessor;

  @Override
  public void getPrice(PriceRequest request, StreamObserver<PriceResponse> responseObserver) {
    log.info("Calling Calculation Service Price Engine");

    // Return a random price for now, will be replaced later
    var price = pricingProcessor.getRandomPrice();

    var priceResponse = PriceResponse.newBuilder().setPrice(price).build();

    responseObserver.onNext(priceResponse);
    responseObserver.onCompleted();
  }
}
