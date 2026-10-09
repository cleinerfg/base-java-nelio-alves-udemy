package org.example.projects.bank;

import org.example.projects.bank.entities.Account;
import org.example.projects.bank.entities.BusinessAccount;
import org.example.projects.bank.entities.SavingsAccount;

public class App {

    public static void main(String[] args) {

        Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DOWNCASTING
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

        // This will throw a ClassCastException at runtime
        // BusinessAccount acc5 = (BusinessAccount) acc3;

        // Safely check the type before downcasting
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
        } else if (acc3 instanceof SavingsAccount) {
            System.out.println("acc3 is a SavingsAccount, performing updateBalance operation.");
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
            System.out.println("Updated balance: " + acc5.getBalance());
        }

        System.out.println("\n--- Savings Account ---");
        SavingsAccount svAcc = new SavingsAccount(1005, "John", 1000.0, 0.02);
        System.out.println("Holder: " + svAcc.getHolder() + ", Balance: " + svAcc.getBalance());
        svAcc.updateBalance();
        System.out.println("After interest update, Balance: " + svAcc.getBalance());
        svAcc.withdraw(50.0);
        System.out.println("After withdrawal, Balance: " + svAcc.getBalance());
    }
}
