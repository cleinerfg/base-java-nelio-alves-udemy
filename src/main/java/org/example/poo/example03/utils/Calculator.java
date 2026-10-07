package org.example.poo.example03.utils;

public final class Calculator {

    private Calculator() {
    }

    public static double circumference(double radius) {
        return 2.0 * Math.PI * radius;
    }

    public static double volume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
