package com.crd.service.tradeservice.data;

import java.util.ArrayList;
import java.util.List;

import com.crd.interfaces.grpc.Trade;

public class TradeResourceProvider {
    public static List<Trade> getTradeListFromTradeSource() {
        return new ArrayList<Trade>() {
            {
                add(Trade.newBuilder().setTradeId(1l).setTradeCounterparty("BOI")
                        .setTradeDate("20221013").setTradeNotional("1000000").setTradeMaturity("20231013").build());
                add(Trade.newBuilder().setTradeId(2l).setTradeCounterparty("MUREX")
                        .setTradeDate("20221013").setTradeNotional("10000000").setTradeMaturity("20251013").build());
                add(Trade.newBuilder().setTradeId(3l).setTradeCounterparty("CRD")
                        .setTradeDate("20221013").setTradeNotional("5000000").setTradeMaturity("20271013").build());
                add(Trade.newBuilder().setTradeId(4l).setTradeCounterparty("StateStreet")
                        .setTradeDate("20221013").setTradeNotional("1000000").setTradeMaturity("20231013").build());
            }
        };
    }
}
