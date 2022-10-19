package com.crd.api.businessApiGateway.application.model;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Trade {
    private String Id;
    private Date startDate;
    private Date endDate;
    private long notional;
    private double price;
    private String counterparty;
    private String trader;
}
