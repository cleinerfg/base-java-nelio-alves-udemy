package org.example.projects.contractmanagement;

import org.example.projects.contractmanagement.entities.Departament;
import org.example.projects.contractmanagement.entities.HourContract;
import org.example.projects.contractmanagement.entities.Worker;
import org.example.projects.contractmanagement.entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Departament departament = new Departament("Vampires");
        Worker worker = new Worker("Elena Gilbert", WorkerLevel.SENIOR, 3000.0, departament);

        HourContract contract1 = new HourContract(LocalDate.of(2003, 6, 1), 50.0, 8);
        HourContract contract2 = new HourContract(LocalDate.of(2004, 7, 15), 60.0, 4);
        HourContract contract3 = new HourContract(LocalDate.of(2003, 6, 15), 40.60, 7);

        worker.addContract(contract1);
        worker.addContract(contract2);
        worker.addContract(contract3);

        System.out.println("==================================================");
        System.out.println("                 WORKER REPORT                    ");
        System.out.println("==================================================");
        printWorkerSummary(worker);
        printContracts(worker.getContracts());

        System.out.println("\n>>> Removing Contract 2 (2004-07-15)...");
        worker.removeContract(contract2);

        System.out.println("\n==================================================");
        System.out.println("          UPDATED CONTRACTS AFTER REMOVAL         ");
        System.out.println("==================================================");
        printContracts(worker.getContracts());

        String inputDate = "06/2003";
        int month = Integer.parseInt(inputDate.substring(0, 2));
        int year = Integer.parseInt(inputDate.substring(3));
        double income = worker.income(year, month);

        System.out.println("\n==================================================");
        System.out.println("                INCOME STATEMENT                  ");
        System.out.println("==================================================");
        System.out.printf("Period: %02d/%d%n", month, year);
        System.out.printf("Base Salary: $ %.2f%n", worker.getBaseSalary());
        System.out.printf("Total Income (Base + Month Contracts): $ %.2f%n", income);
        System.out.println("==================================================");
    }

    private static void printWorkerSummary(Worker worker) {
        System.out.println("Name: " + worker.getName());
        System.out.println("Level: " + worker.getLevel());
        System.out.println("Department: " + worker.getDepartament().getName());
        System.out.printf("Base Salary: $ %.2f%n", worker.getBaseSalary());
    }

    private static void printContracts(List<HourContract> contracts) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n--- Contract List ---");
        if (contracts.isEmpty()) {
            System.out.println("No contracts registered.");
            return;
        }

        for (int i = 0; i < contracts.size(); i++) {
            HourContract c = contracts.get(i);
            System.out.printf("[%d] Date: %s | Value per Hour: $ %.2f | Hours: %d | Total: $ %.2f%n",
                    (i + 1),
                    c.getDate().format(fmt),
                    c.getValuePerHour(),
                    c.getHours(),
                    c.totalValue());
        }
    }
}