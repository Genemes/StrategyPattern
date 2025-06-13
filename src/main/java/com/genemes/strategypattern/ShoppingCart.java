package com.genemes.strategypattern;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void finalizePurchase(double valor) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(valor);
            paymentStrategy.calculateValueWithTax(valor);
        } else {
            System.out.println("No payment method selected!");
        }
    }
}

