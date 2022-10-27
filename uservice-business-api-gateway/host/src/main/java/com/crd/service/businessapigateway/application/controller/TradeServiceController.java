package com.crd.service.businessapigateway.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crd.service.businessapigateway.TradeService;
import com.crd.service.businessapigateway.dto.ApiResponse;
import com.crd.service.businessapigateway.dto.Order;
import com.crd.service.businessapigateway.dto.TradeResponse;
import com.crd.service.businessapigateway.application.service.TradeGrpcService;

import lombok.RequiredArgsConstructor;

/**
 * Controller for Trade operations.
 */
@RestController
@RequestMapping(value = "/trade")
@RequiredArgsConstructor
class TradeServiceController implements TradeService {

  private final TradeGrpcService tradeGrpcService;

  /**
   * Version endpoint.
   */
  @Override
  public ResponseEntity<ApiResponse> version() {
    var version = tradeGrpcService.getVersion();
    var response = new ApiResponse().setResponse(version);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  /**
   * Create order endpoint.
   */
  @Override
  public ResponseEntity<TradeResponse> createOrder(String trader, Order order) {
    order.setTrader(trader);
    var tradeResponse = tradeGrpcService.createNewOrder(order);
    return new ResponseEntity<>(tradeResponse, HttpStatus.CREATED);
  }
}
