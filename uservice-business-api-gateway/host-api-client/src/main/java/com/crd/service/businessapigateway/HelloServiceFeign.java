package com.crd.service.businessapigateway;

import org.springframework.cloud.openfeign.FeignClient;

/** {@inheritDoc} */
@FeignClient(name = "hello-service", url = "http://localhost:3500/", configuration = HelloServiceConfiguration.class)
public interface HelloServiceFeign extends HelloService {

}
