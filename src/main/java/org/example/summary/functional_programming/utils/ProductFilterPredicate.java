package org.example.summary.functional_programming.utils;

import org.example.summary.functional_programming.entities.Product;

import java.util.function.Predicate;

// Concrete implementation of Predicate<T>
public class ProductFilterPredicate implements Predicate<Product> {
    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100.0;
    }
}