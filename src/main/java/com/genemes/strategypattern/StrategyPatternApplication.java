package com.genemes.strategypattern;

public class StrategyPatternApplication {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        double value = 250.00;

        shoppingCart.setPaymentStrategy(new CreditCardPayment());
        shoppingCart.finalizePurchase(value);

        shoppingCart.setPaymentStrategy(new PaypalPayment());
        shoppingCart.finalizePurchase(value);

        shoppingCart.setPaymentStrategy(new DebitCardPayment());
        shoppingCart.finalizePurchase(value);
    }

}
