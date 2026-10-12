package org.example.projects.hotelreservation.exceptions;

public class DomainException extends RuntimeException {
    public DomainException(String msg) {
        super(msg);
    }
}
