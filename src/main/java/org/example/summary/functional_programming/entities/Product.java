package org.example.summary.functional_programming.entities;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Static predicate target
    public static boolean staticFilter(Product p) {
        return p.getPrice() >= 100.0;
    }

    // Non-static predicate target
    public boolean nonStaticFilter() {
        return price >= 100.0;
    }

    // Static consumer target
    public static void staticPriceUpdate(Product p) {
        p.setPrice(p.getPrice() * 1.1);
    }

    // Non-static consumer target
    public void nonStaticPriceUpdate() {
        price *= 1.1;
    }

    // Static function target
    public static String staticUpperCaseName(Product p) {
        return p.getName().toUpperCase();
    }

    // Non-static function target
    public String nonStaticUpperCaseName() {
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + String.format("%.2f", price) + "}";
    }
}