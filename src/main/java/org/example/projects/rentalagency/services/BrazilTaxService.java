package org.example.projects.rentalagency.services;

public class BrazilTaxService implements TaxService {

    public double tax(double amount) {
        double rate = 0.15;
        if (amount < 100.0) rate = 0.2;
        return amount * rate;
    }
}
