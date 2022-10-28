package com.crd.service.businessapigateway.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crd.service.businessapigateway.application.service.CalculationGrpcService;
import com.crd.service.businessapigateway.application.service.GrpcUtils;
import com.crd.service.businessapigateway.application.service.TradeGrpcService;
import com.crd.service.businessapigateway.application.service.impl.CalculationGrpcServiceImpl;
import com.crd.service.businessapigateway.application.service.impl.TradeGrpcServiceImpl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Main app config.
 */
@Configuration
class AppConfig {

  /**
   * Build managed channel for Trade GRPC connection.
   */
  ManagedChannel tradeManagedChannel() {
    var daprAppId = tradeServiceProperties().getDaprAppId();
    return ManagedChannelBuilder.forAddress(tradeServiceProperties().getHost(), tradeServiceProperties().getPort())
        .intercept(GrpcUtils.addTargetDaprApplicationId(daprAppId))
        .usePlaintext()
        .build();
  }

  /**
   * Build managed channel for Calculation GRPC connection.
   */
  ManagedChannel calculationManagedChannel() {
    return ManagedChannelBuilder
        .forAddress(calculationServiceProperties().getHost(), calculationServiceProperties().getPort())
        .usePlaintext()
        .build();
  }

  /**
   * Get the trade service impelementation.
   */
  @Bean
  public TradeGrpcService tradeService() {
    return new TradeGrpcServiceImpl(tradeManagedChannel());
  }

  /**
   * Get the calculation service impelementation.
   */
  @Bean
  public CalculationGrpcService calculationService() {
    return new CalculationGrpcServiceImpl(calculationManagedChannel());
  }

  /**
   * Get the trade service properties.
   */
  @Bean
  public TradeServiceProperties tradeServiceProperties() {
    return new TradeServiceProperties();
  }

  /**
   * Get the calculation service properties.
   */
  @Bean
  public CalculationServiceProperties calculationServiceProperties() {
    return new CalculationServiceProperties();
  }
}
