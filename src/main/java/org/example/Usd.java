package org.example;

public class Usd extends Coin implements Icalculate {
    private final double value = 3.52;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount * value;
    }
}
