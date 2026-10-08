package org.example.datastructures.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOperations {

    public static void main(String[] args) {

        System.out.println("=== Initializing & Adding Fruits ===");
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Kiwi");
        fruits.add(2, "Mango");

        System.out.println("Fruits list: " + fruits);
        System.out.println("Total fruits: " + fruits.size());

        System.out.println("\n=== Accessing & Checking Elements ===");
        System.out.println("Element at index 1: " + fruits.get(1));
        System.out.println("Contains 'Apple'? " + fruits.contains("Apple"));
        System.out.println("Index of 'Kiwi': " + fruits.indexOf("Kiwi"));


        System.out.println("\n=== Bulk Operations ===");
        List<String> tropicalFruits = Arrays.asList("Pineapple", "Papaya");
        fruits.addAll(tropicalFruits); // Adds multiple elements from another collection

        System.out.println("List after addAll(): " + fruits);
        System.out.println("Contains all tropical fruits? " + fruits.containsAll(tropicalFruits));


        System.out.println("\n=== Updating & Replacing Elements ===");

        fruits.set(0, "Blueberry");
        fruits.replaceAll(String::toUpperCase);

        System.out.println("List after set() & replaceAll(): " + fruits);


        System.out.println("\n=== Sorting & Reversing ===");

        fruits.sort(null);
        System.out.println("Alphabetical order: " + fruits);

        Collections.reverse(fruits);
        System.out.println("Reversed order: " + fruits);


        System.out.println("\n=== Sub-listing ===");

        // Extracts a sublist from index 1 (inclusive) to 4 (exclusive)
        List<String> subList = fruits.subList(1, 4);
        System.out.println("Sub-list (index 1 to 4): " + subList);


        System.out.println("\n=== Converting List to Array ===");
        String[] fruitsArray = fruits.toArray(new String[0]);
        System.out.println("Array length: " + fruitsArray.length);
        System.out.println("First array item: " + fruitsArray[0]);


        System.out.println("\n=== Iterating Over List ===");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }


        System.out.println("\n=== Filtering with Streams ===");

        List<String> filteredList = fruits.stream()
                .filter(fruit -> fruit.startsWith("A") || fruit.startsWith("M"))
                .toList();
        System.out.println("Fruits starting with A or M: " + filteredList);

        String firstMatchedFruit = fruits.stream()
                .filter(fruit -> fruit.startsWith("P"))
                .findFirst()
                .orElse("Not found");
        System.out.println("First fruit starting with P: " + firstMatchedFruit);


        System.out.println("\n=== Removing Elements ===");


        fruits.remove("ORANGE");
        fruits.removeIf(fruit -> fruit.startsWith("K"));

        System.out.println("List after removals: " + fruits);


        System.out.println("\n=== Clearing List ===");
        System.out.println("Is list empty? " + fruits.isEmpty());

        fruits.clear();

        System.out.println("Is list empty after clear()? " + fruits.isEmpty());
        System.out.println("Final list: " + fruits);
    }
}