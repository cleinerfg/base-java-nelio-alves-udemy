package org.example.summary.generics.boundedwildcard;

import org.example.projects.geometricshapes.entities.Circle;
import org.example.projects.geometricshapes.entities.Rectangle;
import org.example.projects.geometricshapes.entities.Shape;
import org.example.projects.geometricshapes.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;

public class App {

    static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(Color.RED, 3.0, 2.0));
        shapes.add(new Circle(Color.RED, 2.0));

        System.out.println("Total area shapes: " + totalArea(shapes));

        System.out.println("---------");

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(Color.RED, 3.0));
        circles.add(new Circle(Color.RED, 2.0));

        System.out.println("Total area circles: " + totalArea(circles));
    }

    public static double totalArea(List<? extends Shape> shapes) {
        double sum = 0.0;
        for (Shape shape : shapes) {
            sum += shape.calculateArea();
        }
        return sum;
    }
}
