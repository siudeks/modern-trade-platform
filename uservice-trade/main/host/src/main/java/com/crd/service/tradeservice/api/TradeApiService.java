package com.crd.service.tradeservice.api;

import com.crd.common.grpc.TradeServiceGrpc;
import com.crd.common.grpc.TradeResources.GetVersionRequest;
import com.crd.common.grpc.TradeResources.GetVersionResponse;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * GRPC API for Trade Service Functionality.
 */
@Slf4j
@GrpcService
public class TradeApiService extends TradeServiceGrpc.TradeServiceImplBase {
  @Override
  public void getVersion(GetVersionRequest request, StreamObserver<GetVersionResponse> responseObserver) {
    log.info("Calling Trade Service Version Check");

    var versionResponse = GetVersionResponse.newBuilder().setVersion("CRD Trade Service 1.0").build();

    responseObserver.onNext(versionResponse);
    responseObserver.onCompleted();
  }
}
