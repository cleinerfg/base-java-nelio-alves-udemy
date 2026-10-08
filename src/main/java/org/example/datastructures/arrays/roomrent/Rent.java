package org.example.datastructures.arrays.roomrent;

public class Rent {

    private String name;
    private String email;

    public Rent(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
