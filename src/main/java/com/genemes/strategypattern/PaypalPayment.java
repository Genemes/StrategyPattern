package com.genemes.strategypattern;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(double value) {
        System.out.println("Paying $" + value + " via Paypal.");
        // Lógica específica do Pix (chave, QR Code, etc.)
    }

    @Override
    public double calculateValueWithTax(double value) {
        double tax = value * 0.03; // 3%
        System.out.printf("[Paypal] Value: $%.2f | Tax: $%.2f%n", value, tax);
        return value + tax;
    }
}

