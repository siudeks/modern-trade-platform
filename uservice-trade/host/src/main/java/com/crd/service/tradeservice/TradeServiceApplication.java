package com.crd.service.tradeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Main entry method for the service.
 */
@ConfigurationPropertiesScan
@SpringBootApplication
public class TradeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TradeServiceApplication.class, args);
  }

}
