package org.example.summary.comparator;

import org.example.summary.comparator.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>Quick Comparison of Comparator Approaches in Java</h1>
 *
 * <table border="1" cellpadding="6" cellspacing="0">
 *   <tr>
 *     <th align="left">Approach</th>
 *     <th align="left">Java Version</th>
 *     <th align="left">Verbosity</th>
 *     <th align="left">Reusability</th>
 *     <th align="left">Best Use Case</th>
 *   </tr>
 *   <tr>
 *     <td><b>1. Separate Class</b></td>
 *     <td>Java 1.2+</td>
 *     <td>High</td>
 *     <td>High (standalone file)</td>
 *     <td>Complex comparison logic shared across projects</td>
 *   </tr>
 *   <tr>
 *     <td><b>2. Anonymous Class</b></td>
 *     <td>Java 1.2+</td>
 *     <td>High</td>
 *     <td>Low (one-off inline)</td>
 *     <td>Legacy code base prior to Java 8</td>
 *   </tr>
 *   <tr>
 *     <td><b>3. Lambda Expression</b></td>
 *     <td>Java 8+</td>
 *     <td>Low</td>
 *     <td>Medium (inline / variable)</td>
 *     <td>Short custom logic written directly in place</td>
 *   </tr>
 *   <tr>
 *     <td><b>4. Comparator.comparing</b></td>
 *     <td>Java 8+</td>
 *     <td>Very Low</td>
 *     <td>High (declarative)</td>
 *     <td>Standard field-based sorting (most common)</td>
 *   </tr>
 *   <tr>
 *     <td><b>5. Method Reference</b></td>
 *     <td>Java 8+</td>
 *     <td>Minimal</td>
 *     <td>High (cleanest syntax)</td>
 *     <td>Direct property extraction without transformation</td>
 *   </tr>
 * </table>
 */
public class App {

    public static void main(String[] args) {
        exampleSeparateClassComparator();
        exampleAnonymousClassComparator();
        exampleLambdaComparator();
        exampleFactoryMethodComparator();
        exampleMethodReferenceComparator();
        exampleAdvancedChainingAndNulls();
    }

    private static List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartwatch", 299.50));
        products.add(new Product("Laptop", 2499.99));
        products.add(new Product("TV", 1499.50));
        products.add(new Product("Smartphone", 899.99));
        products.add(new Product("Headphones", 199.00));
        products.add(new Product("Tablet", 549.00));
        return products;
    }

    private static void exampleSeparateClassComparator() {
        System.out.println("==================================================");
        System.out.println("    1. COMPARATOR VIA SEPARATE IMPLEMENTATION     ");
        System.out.println("==================================================");

        List<Product> products = getSampleProducts();

        // Uses external MyComparator class implementing Comparator<Product>
        products.sort(new MyComparator());

        System.out.println("Sorted by Name (via MyComparator class):");
        products.forEach(p -> System.out.println(" - " + p));
        System.out.println();
    }

    private static void exampleAnonymousClassComparator() {
        System.out.println("==================================================");
        System.out.println("    2. COMPARATOR VIA ANONYMOUS INNER CLASS       ");
        System.out.println("==================================================");

        List<Product> products = getSampleProducts();

        // Anonymous class instantiated directly inline (pre-Java 8 style)
        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
            }
        };

        products.sort(comp);

        System.out.println("Sorted by Name (via Anonymous Inner Class):");
        products.forEach(p -> System.out.println(" - " + p));
        System.out.println();
    }

    private static void exampleLambdaComparator() {
        System.out.println("==================================================");
        System.out.println("    3. COMPARATOR VIA LAMBDA EXPRESSION (Java 8+) ");
        System.out.println("==================================================");

        List<Product> products = getSampleProducts();

        // Explicit Lambda assigned to variable or passed directly to sort()
        Comparator<Product> compLambda = (p1, p2) -> p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());
        products.sort(compLambda);

        System.out.println("Sorted by Name (via Lambda variable):");
        products.forEach(p -> System.out.println(" - " + p));

        // Direct inline lambda
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("\nSorted by Price Ascending (via inline Lambda):");
        products.forEach(p -> System.out.println(" - " + p));
        System.out.println();
    }

    private static void exampleFactoryMethodComparator() {
        System.out.println("==================================================");
        System.out.println("  4. COMPARATOR VIA Comparator.comparing()        ");
        System.out.println("==================================================");

        List<Product> products = getSampleProducts();

        // Static factory method taking a key extractor function
        Comparator<Product> compFactory = Comparator.comparing(p -> p.getName().toLowerCase());
        products.sort(compFactory);

        System.out.println("Sorted by Name Case-Insensitive (via Comparator.comparing):");
        products.forEach(p -> System.out.println(" - " + p));
        System.out.println();
    }

    private static void exampleMethodReferenceComparator() {
        System.out.println("==================================================");
        System.out.println("   5. COMPARATOR VIA METHOD REFERENCE (Java 8+)   ");
        System.out.println("==================================================");

        List<Product> products = getSampleProducts();

        // Cleanest syntax when extracting a property without additional logic
        products.sort(Comparator.comparing(Product::getName));
        System.out.println("Sorted by Name (via Product::getName):");
        products.forEach(p -> System.out.println(" - " + p));

        // Sorting by primitive double property
        products.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("\nSorted by Price (via Comparator.comparingDouble):");
        products.forEach(p -> System.out.println(" - " + p));
        System.out.println();
    }

    /**
     * <h1>ADVANCED COMPARATOR FEATURES</h1>
     *
     * <ul>
     *   <li><b>reversed():</b> Inverts the ordering generated by any Comparator.</li>
     *   <li><b>thenComparing():</b> Chains secondary/tertiary sorting rules for tie-breaking.</li>
     *   <li><b>nullsFirst() / nullsLast():</b> Prevents NullPointerException when sorting collections containing null elements or null property values.</li>
     * </ul>
     */
    private static void exampleAdvancedChainingAndNulls() {
        System.out.println("==================================================");
        System.out.println("   6. CHAINING, REVERSING & NULL HANDLING         ");
        System.out.println("==================================================");

        List<Product> products = getSampleProducts();
        // Adding duplicate price product to demonstrate tie-breaking
        products.add(new Product("Budget Phone", 199.00));
        // Adding element with null values to test safe handling
        products.add(new Product(null, 0.0));

        // 1. Reverse Sorting
        System.out.println("Sorted by Price Descending (reversed):");
        products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        products.forEach(p -> System.out.println(" - " + p));

        // 2. Chained Comparison (Primary: Price, Secondary: Name)
        System.out.println("\nChained Sort (Price Asc, then Name Asc):");
        products.sort(
                Comparator.comparing(Product::getPrice)
                        .thenComparing(Product::getName, Comparator.nullsFirst(Comparator.naturalOrder()))
        );
        products.forEach(p -> System.out.println(" - " + p));

        // 3. Null-Safe Comparator
        System.out.println("\nNull-Safe Sort (Null names placed first):");
        products.sort(Comparator.comparing(Product::getName, Comparator.nullsFirst(String::compareToIgnoreCase)));
        products.forEach(p -> System.out.println(" - " + p));
        System.out.println("==================================================");
    }
}