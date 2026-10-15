package org.example.summary.functional_programming.utils;

import org.example.summary.functional_programming.entities.Product;

@FunctionalInterface
public interface ProductTransformer<R> {

    /**
     * Single Abstract Method (SAM).
     * Compilers enforce exactly ONE abstract method in functional interfaces.
     */
    R transform(Product product);

    // Default methods are allowed in functional interfaces (do not count against SAM rule)
    default void printInfo() {
        System.out.println("Executing custom ProductTransformer...");
    }
}
