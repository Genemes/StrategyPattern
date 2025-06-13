# Strategy Pattern Implementation

A Java Spring Boot application demonstrating the Strategy Pattern design pattern for payment processing systems.

## Overview

This project implements the Strategy Pattern to handle different payment methods in a flexible and extensible way. The Strategy Pattern allows you to define a family of algorithms (payment methods), encapsulate each one, and make them interchangeable at runtime.

## Design Pattern: Strategy Pattern

The Strategy Pattern consists of:
- **Strategy Interface**: `PaymentStrategy` - defines the contract for all payment methods
- **Concrete Strategies**: `DebitCardPayment`, `CreditCardPayment`, `PaypalPayment` - specific payment implementations
- **Context**: `ShoppingCart` - uses the payment strategies to process payments

## Project Structure

```
src/
├── main/java/com/genemes/strategypattern/
│   ├── StrategyPatternApplication.java    # Main Spring Boot application
│   ├── PaymentStrategy.java              # Strategy interface
│   ├── DebitCardPayment.java             # Debit card payment implementation
│   ├── CreditCardPayment.java            # Credit card payment implementation
│   ├── PaypalPayment.java                # PayPal payment implementation
│   └── ShoppingCart.java                 # Context class
└── test/java/com/genemes/strategypattern/
    └── StrategyPatternApplicationTests.java
```

## Payment Methods

### Debit Card Payment
- **Tax Rate**: 1%
- **Processing**: Direct debit from bank account

### Credit Card Payment
- **Tax Rate**: 2%
- **Processing**: Credit card transaction

### PayPal Payment
- **Tax Rate**: 1.5%
- **Processing**: PayPal gateway

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Spring Boot 3.x

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd strategy-pattern
```

2. Build the project:
```bash
mvn clean compile
```

3. Run the application:
```bash
mvn spring-boot:run
```

### Usage Example

```java
// Create shopping cart
ShoppingCart cart = new ShoppingCart();
double purchaseAmount = 250.00;

// Pay with debit card (1% tax)
cart.setPaymentStrategy(new DebitCardPayment());
cart.finalizePurchase(purchaseAmount);

// Pay with credit card (2% tax)
cart.setPaymentStrategy(new CreditCardPayment());
cart.finalizePurchase(purchaseAmount);

// Pay with PayPal (1.5% tax)
cart.setPaymentStrategy(new PaypalPayment());
cart.finalizePurchase(purchaseAmount);
```

## Benefits of Strategy Pattern

1. **Flexibility**: Easy to switch between different payment methods at runtime
2. **Extensibility**: New payment methods can be added without modifying existing code
3. **Maintainability**: Each payment method is encapsulated in its own class
4. **Testability**: Each strategy can be tested independently
5. **Open/Closed Principle**: Open for extension, closed for modification

## Adding New Payment Methods

To add a new payment method:

1. Create a new class implementing `PaymentStrategy`:
```java
public class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(double value) {
        System.out.println("Paying $" + value + " via Bitcoin.");
    }

    @Override
    public double calculateValueWithTax(double value) {
        double tax = value * 0.005; // 0.5%
        System.out.printf("[Bitcoin] Value: $%.2f | Tax: $%.2f%n", value, tax);
        return value + tax;
    }
}
```

2. Use it in your application:
```java
cart.setPaymentStrategy(new BitcoinPayment());
cart.finalizePurchase(amount);
```

## Testing

Run the tests using:
```bash
mvn test
```

## Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **Maven** - Dependency management
- **JUnit** - Testing framework

## License

This project is for educational purposes demonstrating the Strategy Pattern implementation.

## References

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.0/maven-plugin)
- [Strategy Pattern - Gang of Four Design Patterns](https://en.wikipedia.org/wiki/Strategy_pattern)