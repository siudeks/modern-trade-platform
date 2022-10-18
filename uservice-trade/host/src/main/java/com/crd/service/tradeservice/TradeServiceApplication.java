package com.crd.service.tradeservice;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;

/**
 * Main entry method for the service.
 */
@SpringBootApplication
public class TradeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TradeServiceApplication.class, args);
  }

  /**
   * Keeps the GRPC server alive.
   */
  @Bean
  public GrpcServerConfigurer keepAliveServerConfigurer() {
    return serverBuilder -> {
      if (serverBuilder instanceof NettyServerBuilder) {
        ((NettyServerBuilder) serverBuilder).keepAliveTime(30, TimeUnit.SECONDS)
          .keepAliveTimeout(5, TimeUnit.SECONDS).permitKeepAliveWithoutCalls(true);
      }
    };
  }
}
