package com.crd.service.businessapigateway.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Application properties for calculation service.
 */
@ConfigurationProperties("calculation-service")
@Setter
@Getter
public class CalculationServiceProperties {
  private String host;
  private int port;
}
