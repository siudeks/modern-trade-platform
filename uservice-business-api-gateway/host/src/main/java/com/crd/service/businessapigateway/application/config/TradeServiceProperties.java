package com.crd.service.businessapigateway.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Application properties for trade service.
 */
@ConfigurationProperties("trade-service")
@Setter
@Getter
public class TradeServiceProperties {
  private String daprAppId;
  private String host;
  private int port;
}
