package com.crd.service.businessapigateway;

import org.springframework.cloud.openfeign.FeignClient;

import com.crd.service.businessapigateway.configuration.CalculationServiceConfiguration;

/** {@inheritDoc} */
@FeignClient(name = "calculation-service", url = "http://localhost:18010/calculation", configuration = CalculationServiceConfiguration.class)
public interface CalculationServiceFeign extends CalculationService {
  
}
