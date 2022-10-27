package com.crd.service.businessapigateway;

import org.springframework.cloud.openfeign.FeignClient;

import com.crd.service.businessapigateway.configuration.TradeServiceConfiguration;

/** {@inheritDoc} */
@FeignClient(name = "trade-service", url = "http://localhost:18010/trade", configuration = TradeServiceConfiguration.class)
public interface TradeServiceFeign extends TradeService {
  
}
