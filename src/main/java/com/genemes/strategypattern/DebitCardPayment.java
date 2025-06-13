package com.genemes.strategypattern;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public void pay(double value) {
        System.out.println("Paying $" + value + " via Debit card.");
    }

    @Override
    public double calculateValueWithTax(double value) {
        double tax = value * 0.01; // 1%
        System.out.printf("[Debit Card] Value: $%.2f | Tax: $%.2f%n", value, tax);
        return value + tax;
    }
}

