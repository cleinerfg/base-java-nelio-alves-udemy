package org.example.summary.diamondproblem.entities;

public class ComboDevice extends Device implements Printer, Scanner {

    public ComboDevice(String serialNumber) {
        super(serialNumber);
    }

    @Override
    public void processDoc(String doc) {
        System.out.println("ComboDevice processing: " + doc);
    }

    @Override
    public void print(String doc) {
        System.out.println("ComboDevice print: " + doc);
    }

    @Override
    public String scan() {
        return "ComboDevice scan";
    }
}
