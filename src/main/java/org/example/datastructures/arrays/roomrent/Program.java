package org.example.datastructures.arrays.roomrent;

public class Program {

    static void main(String[] args) {

        Rent[] rooms = new Rent[10];

        rooms[4] = new Rent("Jeremy", "jeremy@gmail.com");
        rooms[3] = new Rent("Helena", "helena@gmail.com");
        rooms[7] = new Rent("Stefan", "stefan@gmail.com");

        System.out.println("Busy rooms:");
        for (int i = 0; i < 10; i++) {
            if (rooms[i] != null) {
                System.out.println("Room " + i + ": " + rooms[i].getName() + ", " + rooms[i].getEmail());
            }
        }
    }
}
