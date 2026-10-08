package org.example.datastructures.arrays.matrices;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Reading Matrix Size ===");
        System.out.print("Enter the size of the matrix (N x N): ");
        int n = sc.nextInt();

        Matrix numMatrix = new Matrix(n);
        readMatrix(sc, numMatrix);

        numMatrix.printElements();
        numMatrix.printMainDiagonal();
        numMatrix.printSecondaryDiagonal();
        numMatrix.printStatistics();

        showNeighborhood(sc, numMatrix);

        sc.close();
    }

    private static void readMatrix(Scanner sc, Matrix matrix) {
        System.out.println("\n=== Reading Matrix Elements ===");

        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                int value = sc.nextInt();
                matrix.setByPosition(i, j, value);
            }
        }
    }

    private static void showNeighborhood(Scanner sc, Matrix matrix) {
        System.out.println("\n=== Show Neighborhood ===");

        System.out.print("Row: ");
        int row = sc.nextInt();

        System.out.print("Col: ");
        int col = sc.nextInt();

        matrix.printNeighborhoodByPosition(row, col);
    }
}