package org.example.oop.example02;

import org.example.oop.example02.entities.Product;

public class Program {

    static void main(String[] args) {
        Product product = new Product("Laptop", 1200.00, 10);

        System.out.println("Product: " + product.getName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("Quantity in stock: " + product.getQuantity());
        System.out.println("Total in stock: $" + product.totalInStock());

        product.addProducts(5);
        System.out.println("After adding 5 products, new quantity: " + product.getQuantity());

        product.removeProducts(3);
        System.out.println("After removing 3 products, new quantity: " + product.getQuantity());

        System.out.println("---------- To String ----------");
        System.out.println(product);

        System.out.println("---------- Constructor Overcharging ----------");
        Product product2 = new Product("Smartphone", 800.00);
        System.out.println(product2);

        product2.addProducts(5);
        System.out.println("After adding 5 products: \n" + product2);
    }
}
