package org.example.datastructures.map;

import java.util.Objects;

/**
 * <h1>NOTE ON JAVA RECORDS (Java 16+)</h1>
 *
 * <ul>
 *   <li><b>Record Candidate:</b> This class can be refactored into a <code>record</code> (e.g., <code>record ProductKey(int id, String sku)</code>).</li>
 *   <li><b>Automatic Overhead Reduction:</b> Refactoring to a record automatically generates <code>private final</code> fields, canonical constructor, accessor methods (<code>id()</code>, <code>sku()</code>), <code>equals()</code>, <code>hashCode()</code>, and <code>toString()</code>.</li>
 *   <li><b>HashMap Ready:</b> Being immutable with built-in <code>equals()</code> and <code>hashCode()</code> makes records ideal key candidates for <code>HashMap</code>.</li>
 *   <li><b>TreeMap Requirement:</b> Records do <i>NOT</i> provide natural ordering by default. To use a record as a key in a <code>TreeMap</code> with natural sorting, it must still explicitly implement <code>Comparable&lt;ProductKey&gt;</code> and override <code>compareTo()</code> (or use an explicit <code>Comparator</code>).</li>
 * </ul>
 */
public class ProductKey implements Comparable<ProductKey> {
    private final int id;
    private final String sku;

    public ProductKey(int id, String sku) {
        this.id = id;
        this.sku = sku;
    }

    public int getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductKey that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(ProductKey other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ProductKey{id=" + id + ", sku='" + sku + "'}";
    }

}
