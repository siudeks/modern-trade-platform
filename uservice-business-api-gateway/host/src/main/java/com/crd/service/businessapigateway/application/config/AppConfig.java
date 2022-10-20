package com.crd.service.businessapigateway.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crd.service.businessapigateway.application.service.TradeService;
import com.crd.service.businessapigateway.application.service.impl.TradeServiceImpl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Main app config.
 */
@Configuration
public class AppConfig {

  /**
   * Build managed channel for GRPC connection.
   */
  @Bean
  public ManagedChannel managedChannel() {
    return ManagedChannelBuilder.forAddress(applicationProperties().getHost(), applicationProperties().getPort())
      .usePlaintext()
      .build();
  }

  /**
   * Get the trade service impelementation.
   */
  @Bean
  public TradeService tradeService() {
    return new TradeServiceImpl(managedChannel());
  }

  /**
   * Get the application properties.
   */
  @Bean
  public ApplicationProperties applicationProperties() {
    return new ApplicationProperties();
  }
}
