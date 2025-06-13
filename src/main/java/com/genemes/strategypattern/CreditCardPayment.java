package com.genemes.strategypattern;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double value) {
        System.out.println("Paying $" + value + " via Credit card.");
    }

    @Override
    public double calculateValueWithTax(double value) {
        double tax = value * 0.05; // 5%
        System.out.printf("[Credit Card] Value: $%.2f | Tax: $%.2f%n", value, tax);
        return value + tax;
    }
}

