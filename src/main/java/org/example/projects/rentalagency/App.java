package org.example.projects.rentalagency;

import org.example.projects.rentalagency.entities.CarRental;
import org.example.projects.rentalagency.entities.Vehicle;
import org.example.projects.rentalagency.services.RentalService;
import org.example.projects.rentalagency.services.BrazilTaxService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Vehicle vehicle = new Vehicle("Civic");
        LocalDateTime start = LocalDateTime.parse("25/06/2026 10:00", fmt);
        LocalDateTime finish = LocalDateTime.parse("27/06/2026 11:40", fmt);

        CarRental carRental = new CarRental(start, finish, vehicle);

        double pricePerHour = 10.00;
        double pricePerDay = 130.00;

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        System.out.println("=== VEHICLE RENTAL DETAILS ===");
        System.out.println("Vehicle Model: " + carRental.getVehicle().getModel());
        System.out.println("Pickup Date:   " + carRental.getStartDate().format(fmt));
        System.out.println("Return Date:   " + carRental.getEndDate().format(fmt));

        System.out.println("\n=== INVOICE ===");
        System.out.println(String.format("Basic Payment: $%.2f", carRental.getInvoice().getBasicPayment()));
        System.out.println(String.format("Tax Amount:    $%.2f", carRental.getInvoice().getTax()));
        System.out.println(String.format("Total Payment: $%.2f", carRental.getInvoice().getTotalPayment()));
        System.out.println("==============================");
    }
}