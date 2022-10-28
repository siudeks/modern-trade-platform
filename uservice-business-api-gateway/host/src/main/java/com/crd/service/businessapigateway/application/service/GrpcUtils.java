package com.crd.service.businessapigateway.application.service;

import io.grpc.ClientInterceptor;
import io.grpc.Metadata;
import lombok.experimental.UtilityClass;
import io.grpc.stub.MetadataUtils;

/** Some static helper methods around gRpc. Candidate to be moved to shared library. */
@UtilityClass
public class GrpcUtils {
  
  private final Metadata.Key<String> daprHeaderKey = Metadata.Key.of("dapr-app-id", Metadata.ASCII_STRING_MARSHALLER);
  
  /** gRpc interceptor to add to each incoming call header with given {@code targetDaprApplicationId}. */
  public static ClientInterceptor addTargetDaprApplicationId(String targetDaprApplicationId) {
    var extraMetadata = new Metadata();
    extraMetadata.put(daprHeaderKey, targetDaprApplicationId);
    return MetadataUtils.newAttachHeadersInterceptor(extraMetadata);
  }
}
