package org.example.datastructures.arrays.matrices;

import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Reading Matrix Size ===");
        System.out.print("Enter the size of the matrix (N x N): ");
        int n = sc.nextInt();

        int[][] matrix = readMatrix(sc, n);
        printMatrix(matrix);
        printMainDiagonal(matrix);
        printSecondaryDiagonal(matrix);
        printStatistics(matrix);

        sc.close();
    }

    private static int[][] readMatrix(Scanner sc, int n) {
        System.out.println("\n=== Reading Matrix Elements ===");

        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("\n=== Displaying Matrix ===");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("[%2d] ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void printMainDiagonal(int[][] matrix) {
        System.out.println("\n=== Main Diagonal ===");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    private static void printSecondaryDiagonal(int[][] matrix) {
        System.out.println("\n=== Secondary Diagonal ===");

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][n - 1 - i] + " ");
        }
        System.out.println();
    }

    private static int countNegativeNumbers(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) count++;
            }
        }
        return count;
    }

    private static int calculateSum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) sum += value;
        }
        return sum;
    }


    private static void printStatistics(int[][] matrix) {
        System.out.println("\n=== Matrix Statistics ===");
        int negativeCount = countNegativeNumbers(matrix);
        int sum = calculateSum(matrix);

        System.out.println("Total negative numbers: " + negativeCount);
        System.out.println("Sum of all elements: " + sum);
    }
}