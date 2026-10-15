package org.example.summary.functional_programming.utils;

import org.example.summary.functional_programming.entities.Product;

import java.util.function.Function;

// Concrete implementation of Function<T, R>
public class ProductUpperCaseNameFunction implements Function<Product, String> {
    @Override
    public String apply(Product p) {
        return p.getName().toUpperCase();
    }
}