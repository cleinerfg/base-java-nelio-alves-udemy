package org.example.summary.functional_programming.services;

import org.example.summary.functional_programming.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    // Higher-order method accepting a functional interface as strategy
    public double filteredSum(List<Product> products, Predicate<Product> criteria) {
        double sum = 0.0;
        for (Product product : products) {
            if (criteria.test(product)) {
                sum += product.getPrice();
            }
        }
        return sum;
    }
}