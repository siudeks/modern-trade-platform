package com.crd.api.businessApiGateway.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crd.api.businessApiGateway.application.service.TradeService;
import com.crd.api.businessApiGateway.application.service.impl.TradeServiceImpl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Configuration
public class AppConfig {

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress(applicationProperties().getHost(), applicationProperties().getPort())
            .usePlaintext()
            .build();
    }

    @Bean
    public TradeService tradeService() {
        return new TradeServiceImpl(managedChannel());
    }

    @Bean
    public ApplicationProperties applicationProperties() {
        return new ApplicationProperties();
    }
}
