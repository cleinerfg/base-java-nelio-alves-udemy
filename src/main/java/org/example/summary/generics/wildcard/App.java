package org.example.summary.generics.wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    static void main(String[] args) {

        List<Integer> integers = Arrays.asList(121, 32, 32, 24, 55);
        print(integers);

        System.out.println("\n--------------");

        List<String> fruits = Arrays.asList("Apple", "Orange", "Pear", "Strawberry");
        print(fruits);

        System.out.println("\n--------------");

        List<?> list = new ArrayList<Integer>();
        // list.add(3); // compilation error
    }

    private static void print(List<?> list) {
        for (Object item : list) {
            System.out.print(item + ", ");
        }
    }
}
