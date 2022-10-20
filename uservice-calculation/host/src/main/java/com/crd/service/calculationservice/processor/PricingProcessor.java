package com.crd.service.calculationservice.processor;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * Processor for generating prices from input data.
 */
@Component
public class PricingProcessor {
  public double getRandomPrice() {
    return new Random().nextDouble() * 100;
  }
}
