package org.example;

public class Ils extends Coin implements Icalculate{
private final double value = 0.28;
    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount * value ;
    }
}
