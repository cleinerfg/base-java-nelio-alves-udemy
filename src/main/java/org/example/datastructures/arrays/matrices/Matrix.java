package org.example.datastructures.arrays.matrices;

public class Matrix {

    private final int[][] data;
    private final int size;

    public Matrix(int size) {
        this.size = size;

        if (size <= 0)
            throw new IllegalArgumentException("The matrix size must be greater than zero.");

        this.data = new int[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setByPosition(int row, int col, int value) {
        if (!isValidPosition(row, col))
            throw new IndexOutOfBoundsException("Position (" + row + ", " + col + ") outside limits.");

        data[row][col] = value;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < data.length && col >= 0 && col < data[row].length;
    }

    public int getByPosition(int row, int col) {
        if (!isValidPosition(row, col))
            throw new IndexOutOfBoundsException("Position (" + row + ", " + col + ") outside limits.");

        return data[row][col];
    }

    public Integer getLeftByPosition(int row, int col) {
        if (isValidPosition(row, col) && col - 1 >= 0) {
            return data[row][col - 1];
        }
        return null;
    }

    public Integer getRightByPosition(int row, int col) {
        if (isValidPosition(row, col) && col + 1 < data[row].length) {
            return data[row][col + 1];
        }
        return null;
    }

    public Integer getUpByPosition(int row, int col) {
        if (isValidPosition(row, col) && row - 1 >= 0) {
            return data[row - 1][col];
        }
        return null;
    }

    public Integer getDownByPosition(int row, int col) {
        if (isValidPosition(row, col) && row + 1 < data.length) {
            return data[row + 1][col];
        }
        return null;
    }

    public void printElements() {
        System.out.println("\n=== Displaying Matrix ===");

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("[%2d] ", data[i][j]);
            }
            System.out.println();
        }
    }

    public void printMainDiagonal() {
        System.out.println("\n=== Main Diagonal ===");

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i][i] + " ");
        }
        System.out.println();
    }

    public void printSecondaryDiagonal() {
        System.out.println("\n=== Secondary Diagonal ===");

        int n = data.length;
        for (int i = 0; i < n; i++) {
            System.out.print(data[i][n - 1 - i] + " ");
        }
        System.out.println();
    }

    public void printNeighborhoodByPosition(int row, int col) {
        if (!isValidPosition(row, col)) {
            System.out.printf("\nPosition (%d, %d) is invalid.%n", row, col);
            return;
        }

        System.out.printf("\n=== Neighborhood for Position (%d, %d) [Value: %d] ===%n", row, col, getByPosition(row, col));

        Integer up = getUpByPosition(row, col);
        Integer down = getDownByPosition(row, col);
        Integer left = getLeftByPosition(row, col);
        Integer right = getRightByPosition(row, col);

        System.out.println("Top: " + up);
        System.out.println("Bottom: " + down);
        System.out.println("Left: " + left);
        System.out.println("Right: " + right);
    }

    public int countNegativeNumbers() {
        int count = 0;
        for (int[] row : data) {
            for (int value : row) {
                if (value < 0) count++;
            }
        }
        return count;
    }

    public int calculateSum() {
        int sum = 0;
        for (int[] row : data) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }

    public void printStatistics() {
        System.out.println("\n=== Matrix Statistics ===");
        int negativeCount = countNegativeNumbers();
        int sum = calculateSum();

        System.out.println("Total negative numbers: " + negativeCount);
        System.out.println("Sum of all elements: " + sum);
    }
}