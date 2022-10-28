package com.crd.service.businessapigateway.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crd.service.businessapigateway.application.service.CalculationService;
import com.crd.service.businessapigateway.application.service.GrpcUtils;
import com.crd.service.businessapigateway.application.service.TradeService;
import com.crd.service.businessapigateway.application.service.impl.CalculationServiceImpl;
import com.crd.service.businessapigateway.application.service.impl.TradeServiceImpl;

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
  public TradeService tradeService() {
    return new TradeServiceImpl(tradeManagedChannel());
  }

  /**
   * Get the calculation service impelementation.
   */
  @Bean
  public CalculationService calculationService() {
    return new CalculationServiceImpl(calculationManagedChannel());
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
