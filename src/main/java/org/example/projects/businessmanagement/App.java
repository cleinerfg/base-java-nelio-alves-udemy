package org.example.projects.businessmanagement;

import org.example.projects.businessmanagement.entities.Employee;
import org.example.projects.businessmanagement.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alex Green", 50, 20.0));
        employees.add(new OutsourcedEmployee("Bob Brown", 100, 15.0, 200.0));
        employees.add(new Employee("Maria White", 60, 25.0));
        employees.add(new OutsourcedEmployee("John Black", 80, 18.0, 150.0));
        employees.add(new Employee("Anna Grey", 40, 22.0));

        System.out.println("=========================================");
        System.out.println("           PAYMENTS SUMMARY             ");
        System.out.println("=========================================");

        double totalPayroll = 0.0;

        for (Employee emp : employees) {
            double payment = emp.payment();
            totalPayroll += payment;

            String employeeType = (emp instanceof OutsourcedEmployee) ? "Outsourced" : "Regular";

            System.out.printf("Name: %-12s | Type: %-10s | Payment: $%.2f%n",
                    emp.getName(), employeeType, payment);
        }

        System.out.println("-----------------------------------------");
        System.out.printf("Total Employees : %d%n", employees.size());
        System.out.printf("Total Payroll   : $%.2f%n", totalPayroll);
        System.out.println("=========================================");
    }
}