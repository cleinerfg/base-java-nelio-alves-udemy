package org.example.oop.example03;

import org.example.oop.example03.utils.Calculator;
import org.example.oop.example03.utils.CurrencyConverter;

public class Program {

    public static void main(String[] args) {
        double radius = 3.0;

        double circumference = Calculator.circumference(radius);
        double volume = Calculator.volume(radius);

        System.out.printf("Circumference: %.2f%n", circumference);
        System.out.printf("Volume: %.2f%n", volume);

        System.out.println("----- Converter -----");

        double dollarPrice = 5.50;
        double valueInDollars = 200.0;

        double convertedValue = CurrencyConverter.convert(valueInDollars, dollarPrice);
        System.out.printf("Converted value (with tax): %.2f%n", convertedValue);
    }
}
