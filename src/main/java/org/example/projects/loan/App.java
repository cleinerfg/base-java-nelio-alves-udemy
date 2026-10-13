package org.example.projects.loan;

import org.example.projects.loan.services.BrazilInterestService;
import org.example.projects.loan.services.InterestService;
import org.example.projects.loan.services.UsaInterestService;

public class App {

    static void main(String[] args) {


        InterestService brIntService = new BrazilInterestService(2.0);
        InterestService usaIntService = new UsaInterestService(1.0);

        showAndCalculatePayment(brIntService);
        showAndCalculatePayment(usaIntService);

    }

    private static void showAndCalculatePayment(InterestService interestService) {
        double amount = 2500.0;
        int months = 5;

        double payment = interestService.payment(amount, months);

        System.out.println("Payment after " + months + " months is " +
                String.format("%.2f", payment));

        System.out.println("------------");
    }

}
