package org.example.summary.generics.maxvalue;

import org.example.summary.generics.maxvalue.entities.Product;
import org.example.summary.generics.maxvalue.services.CalculationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    static void main(String[] args) {

        System.out.println("---- Max: Product ----");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Computer", 890.50));
        products.add(new Product("Macbook Pro", 900.00));
        products.add(new Product("Table", 450.00));

        System.out.println("Max: " + CalculationService.max(products));

        System.out.println("---- Max: Integer ----");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 12, 32, 234, 245, 721, 376, 284, 339, 110));

        System.out.println("Max: " + CalculationService.max(numbers));
    }
}
