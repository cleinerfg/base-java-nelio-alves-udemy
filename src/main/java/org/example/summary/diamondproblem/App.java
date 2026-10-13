package org.example.summary.diamondproblem;

import org.example.summary.diamondproblem.entities.ComboDevice;
import org.example.summary.diamondproblem.entities.ConcretePrinter;
import org.example.summary.diamondproblem.entities.ConcreteScanner;

public class App {

    static void main(String[] args) {

        ConcretePrinter concretePrinter = new ConcretePrinter("1080");
        concretePrinter.processDoc("My letter");
        concretePrinter.print("My letter");

        System.out.println("----------");

        ConcreteScanner concreteScanner = new ConcreteScanner("1090");
        concreteScanner.processDoc("My email");
        System.out.println("Scan result: " + concreteScanner.scan());

        System.out.println("----------");

        ComboDevice comboDevice = new ComboDevice("2000");
        comboDevice.processDoc("My dissertation");
        comboDevice.print("My dissertation");
        System.out.println("Scan result: " + comboDevice.scan());
    }
}
