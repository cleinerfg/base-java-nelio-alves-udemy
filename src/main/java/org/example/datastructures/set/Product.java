package org.example.datastructures.set;

import java.util.Objects;

class Product implements Comparable<Product> {
    private final Integer id;
    private final String name;

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Step 1: Set uses hashCode() to locate the correct bucket
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Step 2: Set uses equals() to check exact equality within that bucket
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.id, other.id);
    }
}