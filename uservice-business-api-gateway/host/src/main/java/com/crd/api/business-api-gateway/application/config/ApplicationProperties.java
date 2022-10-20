package com.crd.api.businessapigateway.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * Application properties for trade service.
 */
@ConfigurationProperties("trade-service")
@Setter
@Getter
public class ApplicationProperties {
  private String host;
  private int port;
}
