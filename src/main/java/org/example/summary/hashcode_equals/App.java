package org.example.summary.hashcode_equals;

import org.example.summary.hashcode_equals.entities.Client;

public class App {

    static void main(String[] args) {

        Client c1 = new Client("Maria", "maria@email.com");
        Client c2 = new Client("Alex", "alex@email.com");
        Client c3 = new Client("Maria", "maria@email.com");

        System.out.println("c1 hashcode: " + c1.hashCode());
        System.out.println("c2 hashcode: " + c2.hashCode());
        System.out.println("c3 hashcode: " + c3.hashCode());
        System.out.println("c1.equals(c2) = " + c1.equals(c2)); // Compare by content
        System.out.println("c1.equals(c3) = " + c1.equals(c3));
        System.out.println("c1 == c3 = " + (c1 == c3)); // Compare the memory reference

        System.out.println("----------------");

        String str1 = "Maria";
        String str2 = "Maria";
        System.out.println("str1 == str2 = " + (str1 == str2)); // true

        String str3 = new String("Maria");
        String str4 = new String("Maria");
        System.out.println("str3 == str4 = " + (str3 == str4)); // false -> compare reference

        // All have the same hashcode
        System.out.println("str1 hashcode: " + str1.hashCode());
        System.out.println("str2 hashcode: " + str2.hashCode());
        System.out.println("str3 hashcode: " + str3.hashCode());
        System.out.println("str4 hashcode: " + str4.hashCode());
    }
}
