package org.example.projects.bank.exceptions;

public class InsufficientFoundsException extends RuntimeException {
    public InsufficientFoundsException(double amount) {
        super("Insufficient founds for " + amount);
    }
}
