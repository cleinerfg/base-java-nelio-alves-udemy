package org.example.summary.functional_programming.utils;

import org.example.summary.functional_programming.entities.Product;

import java.util.function.Consumer;

// Concrete implementation of Consumer<T>
public class ProductPriceUpdateConsumer implements Consumer<Product> {
    @Override
    public void accept(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }
}