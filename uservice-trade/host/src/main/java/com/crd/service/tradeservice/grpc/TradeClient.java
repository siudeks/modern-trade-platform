package com.crd.service.tradeservice.grpc;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.protobuf.Descriptors.FieldDescriptor;

import com.crd.common.grpc.Calculation;
import com.crd.common.grpc.CalculationServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class TradeClient {
    @GrpcClient("calculation-service")
    private CalculationServiceGrpc.CalculationServiceBlockingStub calculationServiceBlockingStub;

    @GrpcClient("calculation-service")
    private CalculationServiceGrpc.CalculationServiceStub calculationServiceStub;

    public Map<FieldDescriptor, Object> getCalculationById(long calculationId) {
        return calculationServiceBlockingStub.getCalculation(Calculation.newBuilder().setTradeId(calculationId).build())
                .getAllFields();
    }
}
