package com.crd.service.tradeservice.grpc;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * The properties for the gRPC server that will be started as part of the application.
 */
@Data
@ConfigurationProperties("grpc.server")
public class GrpcServerProperties {

  /**
   * Server port to listen on. Defaults to {@code 9090}.
   *
   * @param port The port the server should listen on.
   * @return The port the server will listen on.
   */
  private int port = 9090;
}
