package org.example.projects.geometricshapes.entities;

import org.example.projects.geometricshapes.entities.enums.Color;

public abstract class AbstractShape implements Shape {

    protected Color color;
    protected Double area;

    protected AbstractShape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Double getArea() {
        return area;
    }
}
