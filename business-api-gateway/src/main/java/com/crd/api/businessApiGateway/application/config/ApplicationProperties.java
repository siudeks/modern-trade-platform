package com.crd.api.businessApiGateway.application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("trade-service")
@Setter
@Getter
public class ApplicationProperties {
    private String host;
    private int port;
}
