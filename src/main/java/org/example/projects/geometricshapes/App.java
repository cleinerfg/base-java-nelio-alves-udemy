package org.example.projects.geometricshapes;

import org.example.projects.geometricshapes.entities.AbstractShape;
import org.example.projects.geometricshapes.entities.Circle;
import org.example.projects.geometricshapes.entities.Rectangle;
import org.example.projects.geometricshapes.entities.enums.Color;

import java.util.List;

public class App {

    static void main(String[] args) {

        List<AbstractShape> shapes = List.of(
                new Circle(Color.BLUE, 3.0),
                new Rectangle(Color.RED, 4.0, 5.0));

        for (AbstractShape s : shapes) {
            System.out.printf("Color: %s - Area: %.2f \n", s.getColor(), s.getArea());
        }
    }
}
