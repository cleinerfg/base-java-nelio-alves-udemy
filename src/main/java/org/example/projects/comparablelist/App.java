package org.example.projects.comparablelist;

import org.example.projects.comparablelist.entities.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Maria", 3500.0));
        employees.add(new Employee("João", 2800.0));
        employees.add(new Employee("Ana", 4200.0));
        employees.add(new Employee("Carlos", 1900.0));
        employees.add(new Employee("Beatriz", 5100.0));
        employees.add(new Employee("Lucas", 3100.0));
        employees.add(new Employee("Mariana", 2600.0));
        employees.add(new Employee("Gabriel", 4800.0));
        employees.add(new Employee("Sofia", 3900.0));
        employees.add(new Employee("Matheus", 2200.0));

        System.out.println("Before sorting:");
        print(employees);

        System.out.println("---------");

        System.out.println("After sorting:");
        Collections.sort(employees);
        print(employees);
    }

    private static void print(List<Employee> employees) {
        int index = 1;
        for (Employee emp : employees) {
            System.out.println(index + " - " + emp.getName() + " - R$ " + emp.getSalary());
            index++;
        }
    }
}
