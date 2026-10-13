package org.example.summary.generics.listofvalues;

import org.example.summary.generics.listofvalues.services.PrintService;

public class App {

    static void main(String[] args) {

        System.out.println("Print Service <Integer>");

        PrintService<Integer> ps1 = new PrintService<>();

        ps1.addValue(10);
        ps1.addValue(6);
        ps1.addValue(32);
        ps1.addValue(20);

        ps1.print();
        System.out.println("First value: " + ps1.getFirst());

        System.out.println("------------------");

        System.out.println("Print Service <String>");

        PrintService<String> ps2 = new PrintService<>();
        ps2.addValue("Maria");
        ps2.addValue("Juan");
        ps2.addValue("Grape");
        ps2.addValue("Lion");

        ps2.print();
        System.out.println("First value: " + ps2.getFirst());
    }
}
