package org.example.projects.hotelreservation;

import org.example.projects.hotelreservation.entitities.Reservation;
import org.example.projects.hotelreservation.exceptions.DomainException;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        System.out.println("--- Starting Reservation ---");

        try {
            // 1. Successful Reservation
            Reservation res = new Reservation(
                    802,
                    LocalDate.parse("2022-04-01"),
                    LocalDate.parse("2022-04-10"));
            System.out.println("Initial Reservation: " + res);

            // 2. Successful Update
            res.updateDates(LocalDate.parse("2022-04-15"), LocalDate.parse("2022-04-20"));
            System.out.println("Update (Valid): Success! New State: " + res);

            // 3. Error: Past Dates
            res.updateDates(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-05"));

        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }

        try {
            Reservation res2 = new Reservation(
                    803,
                    LocalDate.parse("2022-07-01"),
                    LocalDate.parse("2022-08-10"));
            System.out.println("Initial Reservation: " + res2);

            // 4. Error: Check-out before Check-in
            res2.updateDates(LocalDate.parse("2022-05-10"), LocalDate.parse("2022-05-05"));
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException _) {
            System.out.println("Unexpected error in reservation");
        }
    }

}
