package org.example.datastructures.arrays;

public class NegativeNumArray {

    static void main(String[] args) {

        int[] numbers = {-5, 3, -2, 7, -1, 4};

        int qtNegativeNumbers = 0;
        System.out.println("Negative numbers in the array:");
        for (int number : numbers) {
            if (number < 0) {
                qtNegativeNumbers += 1;
                System.out.println(number);
            }
        }

        System.out.println("Total negative numbers: " + qtNegativeNumbers);
    }
}
