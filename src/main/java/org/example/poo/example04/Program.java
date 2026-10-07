package org.example.poo.example04;

import org.example.poo.example04.entities.Account;

public class Program {

    public static void main(String[] args) {
        System.out.println("=== ACCOUNT DEMO ===");

        System.out.println("\n--- Account 1 (With Initial Deposit) ---");
        Account acc1 = new Account(1001, "Stefan Salvatore", 500.0);
        System.out.println("Created Account #" + acc1.getNumber() + " for " + acc1.getHolder());
        System.out.println("Initial Balance: $" + acc1.getBalance());

        System.out.println("\n--- Deposit Transaction ---");
        acc1.deposit(200.0);
        System.out.println("Deposited: $200.0");
        System.out.println("Current Balance: $" + acc1.getBalance());

        System.out.println("\n--- Successful Withdrawal ---");
        acc1.withdraw(100.0);
        System.out.println("Withdrew: $100.0 (Fee: $" + Account.WITHDRAW_FEE + ")");
        System.out.println("Current Balance: $" + acc1.getBalance());

        System.out.println("\n--- Failed Withdrawal Attempt ---");
        System.out.println("Attempting to withdraw $700.0...");
        acc1.withdraw(700.0);
        System.out.println("Current Balance: $" + acc1.getBalance());

        System.out.println("\n--- Account 2 (No Initial Deposit) ---");
        Account acc2 = new Account(1002, "Jeremy Gilbert");
        System.out.println("Created Account #" + acc2.getNumber() + " for " + acc2.getHolder());
        System.out.println("Initial Balance: $" + acc2.getBalance());

        System.out.println("====================");
    }
}