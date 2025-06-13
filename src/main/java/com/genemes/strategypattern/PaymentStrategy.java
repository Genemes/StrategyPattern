package com.genemes.strategypattern;

public interface PaymentStrategy {
    void pay(double value);
    double calculateValueWithTax(double value);
}
