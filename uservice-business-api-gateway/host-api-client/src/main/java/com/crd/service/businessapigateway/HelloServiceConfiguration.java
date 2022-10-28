package com.crd.service.businessapigateway;

import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

/** Placeholder to customize Feign client. */
class HelloServiceConfiguration {

  static final String DAPR_APP_ID_KEY = "dapr-app-id";
  static final String DAPR_APP_ID_GATEWAY = "uservice-business-api-gateway";

  /**
   * Adds dapr-add-id to requests so that REST calls are directed to gateway µservice.
   * Note: I tried to put such header in mopre static method (is it is static value),
   * but it does not work with e.g. @Headers annotation on top of {@link HelloServiceFeign}.
   */
  @Bean
  public RequestInterceptor requestInterceptor() {
    return requestTemplate -> requestTemplate.header(DAPR_APP_ID_KEY, DAPR_APP_ID_GATEWAY);
  }
}
