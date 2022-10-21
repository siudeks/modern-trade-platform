package com.crd.service.businessapigateway.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crd.service.businessapigateway.application.model.Order;
import com.crd.service.businessapigateway.application.model.Trade;
import com.crd.service.businessapigateway.application.service.TradeService;
import com.crd.service.businessapigateway.resource.ApiResponse;
import com.crd.service.businessapigateway.resource.TradeResponse;

/**
 * Controller for Trade operations.
 */
@RestController
@RequestMapping(value = "/trade")
public class TradeServiceController {
  @Autowired
  private TradeService tradeService;

  /**
   * Version endpoint.
   */
  @GetMapping("/version")
  public ResponseEntity<ApiResponse> getVersion() {
    var version = tradeService.getVersion();
    var versionResponse = new ApiResponse(version);
    return new ResponseEntity<>(versionResponse, HttpStatus.OK);
  }

  /**
   * Individual trade query endpoint.
   */
  @GetMapping("/{tradeId}")
  public ResponseEntity<Trade> getTrade(@PathVariable String tradeId) {
    var trade = tradeService.getTrade(tradeId);
    return new ResponseEntity<>(trade, HttpStatus.CREATED);
  }

  /**
   * Create order endpoint.
   */
  @PostMapping("/order")
  public ResponseEntity<TradeResponse> createOrder(@RequestHeader(value = "trader") String trader, @RequestBody Order order) {
    order.setTrader(trader);
    var tradeResponse = tradeService.createNewOrder(order);
    return new ResponseEntity<>(tradeResponse, HttpStatus.CREATED);
  }
}
