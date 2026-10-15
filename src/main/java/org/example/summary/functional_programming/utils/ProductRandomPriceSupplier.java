package org.example.summary.functional_programming.utils;

import java.util.function.Supplier;

// Concrete implementation of Supplier<T>
public class ProductRandomPriceSupplier implements Supplier<Double> {
    @Override
    public Double get() {
        return 5.0 + (Math.random() * (500.0 - 5.0));
    }
}