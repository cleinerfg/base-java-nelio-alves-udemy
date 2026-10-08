package org.example.datastructures.arrays;

import java.util.Scanner;

public class HeightArray {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = 3;

        double[] heights = new double[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter height for person " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
        }

        sc.close();

        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += heights[i];
        }

        System.out.println("Average height: " + (sum / size));
    }
}
