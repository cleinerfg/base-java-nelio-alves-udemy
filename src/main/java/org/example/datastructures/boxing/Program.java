package org.example.datastructures.boxing;

public class Program {

    static void main(String[] args) {

        int a = 10;
        Object obj = a;
        System.out.println("Boxed value: " + obj);

        int b = (int) obj + 5;
        System.out.println("Unboxed value: " + b);

        // Wrapper Class
        Integer objInt = a;
        System.out.println("Wrapper Class value: " + objInt);
        
    }
}
