package org.example;

public class MathSummary {

    public static void main(String[] args) {

        // Basic operations
        System.out.println("=== Basic Operations ===");

        System.out.println("Max: " + Math.max(10, 20));
        System.out.println("Min: " + Math.min(10, 20));
        System.out.println("Absolute: " + Math.abs(-15));
        System.out.println("Sign: " + Math.signum(-10));

        // Powers and roots
        System.out.println("\n=== Powers and Roots ===");

        System.out.println("Power: " + Math.pow(2, 3));
        System.out.println("Square root: " + Math.sqrt(25));
        System.out.println("Cube root: " + Math.cbrt(27));

        // Rounding
        System.out.println("\n=== Rounding ===");

        System.out.println("Round: " + Math.round(10.6));
        System.out.println("Ceiling: " + Math.ceil(10.2));
        System.out.println("Floor: " + Math.floor(10.8));

        // Random
        System.out.println("\n=== Random ===");

        System.out.println("Random [0, 1): " + Math.random());
        System.out.println("Random integer [1, 10]: " +
                (int) (Math.random() * 10) + 1);

        // Trigonometry
        System.out.println("\n=== Trigonometry ===");

        System.out.println("Sin 90°: " + Math.sin(Math.toRadians(90)));
        System.out.println("Cos 60°: " + Math.cos(Math.toRadians(60)));
        System.out.println("Tan 45°: " + Math.tan(Math.toRadians(45)));

        // Angles
        System.out.println("\n=== Angles ===");

        System.out.println("Radians: " + Math.toRadians(180));
        System.out.println("Degrees: " + Math.toDegrees(Math.PI));

        // Constants
        System.out.println("\n=== Constants ===");

        System.out.println("PI: " + Math.PI);
        System.out.println("E: " + Math.E);

        // Logarithms
        System.out.println("\n=== Logarithms ===");

        System.out.println("Natural log: " + Math.log(Math.E));
        System.out.println("Base-10 log: " + Math.log10(100));

        // Exponential
        System.out.println("\n=== Exponential ===");

        System.out.println("e^2: " + Math.exp(2));

        // Integer division helpers
        System.out.println("\n=== Division ===");

        System.out.println("Exact division: " + Math.floorDiv(10, 3));
        System.out.println("Remainder: " + Math.floorMod(10, 3));
    }
}