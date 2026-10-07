package org.example.poo.example01;

import org.example.poo.example01.entities.Triangle;

public class Program {

    public static void main(String[] args) {
        Triangle x = new Triangle(5.0, 6.0, 5.0);
        Triangle y = new Triangle(4.0, 5.0, 3.0);

        System.out.printf("Area X: %.4f%n", x.calculateArea());
        System.out.printf("Area Y: %.4f%n", y.calculateArea());
    }
}