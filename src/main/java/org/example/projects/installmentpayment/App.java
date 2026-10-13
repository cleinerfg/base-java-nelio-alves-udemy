package org.example.projects.installmentpayment;

import org.example.projects.installmentpayment.entities.Contract;
import org.example.projects.installmentpayment.services.ContractService;
import org.example.projects.installmentpayment.services.PaypalPaymentService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

    static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int id = 1345;
        LocalDate date = LocalDate.parse("23/05/2026", fmt);
        double amount = 600;

        Contract contract = new Contract(id, date, amount);

        ContractService contractService = new ContractService(new PaypalPaymentService());
        contractService.processPayment(contract, 3);

        System.out.println(contract.getInstallments());
    }
}
