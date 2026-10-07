package org.example.summary;

import java.util.Scanner;

public class ScannerSummary {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read String
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Read int
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Read double
        System.out.print("Enter your height: ");
        double height = scanner.nextDouble();

        // Read boolean
        System.out.print("Are you a student? (true/false): ");
        boolean student = scanner.nextBoolean();

        // Read char
        System.out.print("Enter your gender initial: ");
        char gender = scanner.next().charAt(0);

        // Display data
        System.out.println("\n--- User Data ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Student: " + student);
        System.out.println("Gender: " + gender);

        // Close Scanner
        scanner.close();
    }
}