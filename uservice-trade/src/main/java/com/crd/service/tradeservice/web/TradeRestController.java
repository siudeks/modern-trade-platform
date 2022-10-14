package com.crd.service.tradeservice.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crd.service.tradeservice.grpc.TradeClient;
import com.google.protobuf.Descriptors.FieldDescriptor;

@RestController
public class TradeRestController {

    @Autowired
    private TradeClient tradeGrpcClient;

    @RequestMapping("/")
    public String echo() {
        return "Trade Service 1.0";
    }

    @RequestMapping(path = "/trade/{tradeId}")
    public Map<FieldDescriptor, Object> getTradebyId(@PathVariable Long tradeId) throws InterruptedException {
        return tradeGrpcClient.getCalculationById(tradeId);
    }
}
