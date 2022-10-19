package com.crd.service.tradeservice.grpc;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/** Registers all discoverable gRpc services to allow them be reachable. */
@Component
@RequiredArgsConstructor
public class GrpcServer implements AutoCloseable {

  private final BindableService[] services;
  private final GrpcServerProperties properties;


  private Server server;

  @PostConstruct
  @SneakyThrows
  void start() {
    var port = properties.getPort();
    var builder = ServerBuilder.forPort(port);
    for (var bindableService : services) {
      builder.addService(bindableService);
    }
    server = builder.build();

    server.start();
  }

  @Override
  public void close() throws Exception {
    server.shutdownNow();
  }
}
