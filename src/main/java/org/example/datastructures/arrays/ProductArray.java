package org.example.datastructures.arrays;

import org.example.oop.example02.entities.Product;

public class ProductArray {

    static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Product("Laptop", 1200.00, 10);
        products[1] = new Product("Smartphone", 800.00);
        products[2] = new Product("Tablet", 500.00, 5);

        double sum = 0.0;
        for (Product p : products) {
            sum += p.getPrice();
            System.out.println(p);
        }

        System.out.printf("Average prices: %.2f", sum / products.length);

    }

}

