package org.example.poo.example03.utils;

public final class CurrencyConverter {

    private CurrencyConverter() {
    }

    public static final double IOF = 0.06;

    public static double convert(double value, double dollarPrice) {
        double total = value * dollarPrice;
        double tax = total * IOF;
        return total + tax;
    }
}
