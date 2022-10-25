package com.crd.service.businessapigateway;

import org.springframework.cloud.openfeign.FeignClient;

/** {@inheritDoc} */
@FeignClient(name = "hello-service", url = "http://localhost:18010/", configuration = HelloServiceConfiguration.class)
public interface HelloServiceFeign extends HelloService {

}
