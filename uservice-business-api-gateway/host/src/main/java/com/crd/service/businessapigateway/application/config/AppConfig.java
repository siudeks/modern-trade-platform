package com.crd.service.businessapigateway.application.config;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crd.service.businessapigateway.application.service.GrpcUtils;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.val;

/**
 * Main app config.
 */
@Configuration
@ConfigurationPropertiesScan 
class AppConfig {

  /**
   * Build managed channel for Trade GRPC connection.
   */
  @Bean
  Closeable.Of<ManagedChannel> tradeManagedChannel(TradeServiceProperties props) {
    var daprAppId = props.getDaprAppId();
    var channel = ManagedChannelBuilder.forAddress(props.getHost(), props.getPort())
        .intercept(GrpcUtils.addTargetDaprApplicationId(daprAppId))
        .usePlaintext()
        .build();
    return asCloseable(channel);
  }

  /**
   * Build autocseable managed channel for Calculation GRPC connection.
   */
  @Bean
  Closeable.Of<ManagedChannel> calculationManagedChannel(CalculationServiceProperties props) {
    var daprAppId = props.getDaprAppId();
    var channel = ManagedChannelBuilder
        .forAddress(props.getHost(), props.getPort())
        .intercept(GrpcUtils.addTargetDaprApplicationId(daprAppId))
        .usePlaintext()
        .build();
    return asCloseable(channel);
  }

  // packs non closeable item to AutoCloseable element
  private static Closeable.Of<ManagedChannel> asCloseable(ManagedChannel item) {
    val someNotTestedShutdownForChannelsInSeconds = 3;
    Consumer<ManagedChannel> disposer = (it) -> {
      item.shutdown();
      try {
        item.awaitTermination(someNotTestedShutdownForChannelsInSeconds, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    };
    return Closeable.of(item, disposer);
  }
}
