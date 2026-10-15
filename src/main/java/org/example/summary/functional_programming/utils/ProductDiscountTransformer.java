package org.example.summary.functional_programming.utils;

import org.example.summary.functional_programming.entities.Product;

public class ProductDiscountTransformer implements ProductTransformer<Double> {
    @Override
    public Double transform(Product product) {
        return product.getPrice() * 0.85;
    }
}
