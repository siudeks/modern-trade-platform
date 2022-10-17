package com.crd.api.businessApiGateway.resource;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
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

import com.crd.api.businessApiGateway.application.model.Trade;
import com.crd.api.businessApiGateway.application.service.TradeService;

@RestController
@RequestMapping(value = "/trade")
public class TradeGatewayController {
    @Autowired
    private TradeService tradeService;

    @GetMapping("/version")
    public ResponseEntity<ApiResponse> getVersion() {
        var version = tradeService.getVersion();
        var versionResponse = new ApiResponse(version);
        return new ResponseEntity<>(versionResponse, HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<TradeResponse> createTrade(@RequestHeader(value = "trader") String trader, @RequestBody Trade trade) {
        trade.setTrader(trader);
        var tradeId = tradeService.createNewTrade(trade);
        var tradeResponse = new TradeResponse(tradeId);
        return new ResponseEntity<>(tradeResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{tradeId}")
    public ResponseEntity<Trade> getTrade(@PathVariable @NotBlank String tradeId) {
        var trade = tradeService.getTrade(tradeId);
        return new ResponseEntity<>(trade, HttpStatus.CREATED);
    }
}
