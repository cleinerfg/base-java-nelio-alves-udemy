package org.example.summary.functional_programming;

import org.example.summary.functional_programming.entities.Product;
import org.example.summary.functional_programming.services.ProductService;
import org.example.summary.functional_programming.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * <h1>Comprehensive Summary of Functional Programming in Java 8+</h1>
 *
 * <p>
 * Functional programming in Java centers around <b>Functional Interfaces</b> (interfaces with exactly one abstract method,
 * known as SAM - Single Abstract Method) enabled by <b>Lambda Expressions</b> and <b>Method References</b>.
 * </p>

 * <h2>1. Core Concepts & Implementation Strategies</h2>
 * <table border="1" cellpadding="6" cellspacing="0">
 *   <tr>
 *     <th align="left">Strategy</th>
 *     <th align="left">Syntax Structure</th>
 *     <th align="left">Description</th>
 *   </tr>
 *   <tr>
 *     <td><b>A. Interface Class</b></td>
 *     <td><code>new CustomClass()</code></td>
 *     <td>Concrete class implementation in a separate file. High reusability, verbose.</td>
 *   </tr>
 *   <tr>
 *     <td><b>B. Static Method Ref</b></td>
 *     <td><code>Class::staticMethod</code></td>
 *     <td>Delegates execution to a static utility method matching the SAM signature.</td>
 *   </tr>
 *   <tr>
 *     <td><b>C. Non-Static Method Ref</b></td>
 *     <td><code>Class::instanceMethod</code></td>
 *     <td>Invokes an instance method on the target object passed as argument at runtime.</td>
 *   </tr>
 *   <tr>
 *     <td><b>D. Declared Lambda</b></td>
 *     <td><code>Interface&lt;T&gt; f = x -&gt; expr;</code></td>
 *     <td>Assigns an explicit lambda expression to a functional interface reference variable.</td>
 *   </tr>
 *   <tr>
 *     <td><b>E. Inline Lambda</b></td>
 *     <td><code>method(x -&gt; expr)</code></td>
 *     <td>Passes anonymous behavior directly into higher-order methods (in-place execution).</td>
 *   </tr>
 * </table>

 * <h2>2. Built-in Functional Interfaces Overview</h2>
 * <ul>
 *   <li><b>Predicate&lt;T&gt; [ T -&gt; boolean ]:</b> Evaluates a boolean condition on input <code>T</code> (e.g., <code>removeIf</code>).</li>
 *   <li><b>Consumer&lt;T&gt; [ T -&gt; void ]:</b> Performs side-effects or actions on input <code>T</code> without returning a value (e.g., <code>forEach</code>).</li>
 *   <li><b>Function&lt;T, R&gt; [ T -&gt; R ]:</b> Transforms an input of type <code>T</code> into a result of type <code>R</code> (e.g., <code>Stream.map</code>).</li>
 *   <li><b>Supplier&lt;T&gt; [ () -&gt; T ]:</b> Takes no arguments and produces/supplies a value of type <code>T</code> (e.g., lazy generation/factories).</li>
 *   <li><b>DoubleSupplier [ () -&gt; double ]:</b> Specialized primitive variation to avoid boxing/unboxing overhead.</li>
 *   <li><b>Higher-Order Functions [ (..., f(x)) -&gt; R ]:</b> Methods that accept functional interfaces as parameters to execute dynamic behavior.</li>
 * </ul>

 * <h2>3. Additional Note: Generic Type Parameter 'R'</h2>
 * <ul>
 *   <li><b>Naming Convention:</b> In Java Generics, single uppercase letters follow standardized rules. <code>'R'</code> stands for <b>Result</b> or <b>Return type</b> (while <code>'T'</code> represents <i>Type</i>, <code>'E'</code> represents <i>Element</i>, <code>'K'</code> and <code>'V'</code> represent <i>Key</i> and <i>Value</i>).</li>
 *   <li><b>Polymorphic Return Type:</b> Using <code>&lt;R&gt;</code> avoids hardcoding a concrete type (such as <code>Double</code> or <code>String</code>), making custom functional interfaces highly flexible and reusable across different contexts.</li>
 *   <li><b>Dynamic Type Resolution:</b> The actual return type is resolved at compile time based on caller usage (e.g., returning a <code>Double</code> for calculated prices vs a <code>String</code> for formatted labels).</li>
 *   <li><b>Standard API Alignment:</b> This design directly mirrors standard Java functional interfaces, such as <code>java.util.function.Function&lt;T, R&gt;</code>.</li>
 * </ul>
 */
public class App {

    public static void main(String[] args) {
        exampleBuiltInFunctionalInterfaces();
        exampleUsePredicate();
        exampleUseConsumer();
        exampleUseFunction();
        exampleUseSupplier();
        exampleHigherOrderFunction();
        exampleCustomFunctionalInterface();
    }

    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("TV", 500.00));
        products.add(new Product("Smart TV", 550.00));
        products.add(new Product("Tablet", 430.55));
        products.add(new Product("HDD 500GB", 70.99));
        products.add(new Product("Pendrive", 10.00));
        return products;
    }

    private static void exampleBuiltInFunctionalInterfaces() {
        System.out.println("==================================================");
        System.out.println("   1. STANDARD BUILT-IN FUNCTIONAL INTERFACES     ");
        System.out.println("==================================================");

        // Predicate<T> -> Takes T, returns boolean
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Predicate (Is 10 even?)   : " + isEven.test(10));
        System.out.println("Predicate (Is 7 even?)    : " + isEven.test(7));

        // Consumer<T> -> Takes T, returns void
        Consumer<String> printer = message -> System.out.println("Consumer Action Output  : " + message);
        printer.accept("Processing order #1092");

        // Function<T, R> -> Takes T, returns R
        Function<String, Integer> stringLengthCalculator = text -> text.length();
        System.out.println("Function (String Length) : " + stringLengthCalculator.apply("Functional Java"));

        // Supplier<T> -> Takes no argument (), returns T
        Supplier<Double> randomValueSupplier = Math::random;
        System.out.println("Supplier (Generated Val) : " + String.format("%.2f", randomValueSupplier.get()));

        // DoubleSupplier -> Primitive specialization, takes no argument (), returns double
        DoubleSupplier randomDoubleSupplier = () -> 5.0 + (Math.random() * (500.0 - 5.0));
        System.out.println("DoubleSupplier (Gen Val) : " + String.format("%.2f", randomDoubleSupplier.getAsDouble()));
        System.out.println();
    }

    private static void exampleUsePredicate() {
        System.out.println("==================================================");
        System.out.println("         2. USE PREDICATE [ T -> boolean ]        ");
        System.out.println("==================================================");

        // A. Interface Implementation
        List<Product> listA = getProducts();
        listA.removeIf(new ProductFilterPredicate());
        System.out.println("A. Interface Class     : " + listA);

        // B. Static Method Reference
        List<Product> listB = getProducts();
        listB.removeIf(Product::staticFilter);
        System.out.println("B. Static Method Ref   : " + listB);

        // C. Non-Static Method Reference
        List<Product> listC = getProducts();
        listC.removeIf(Product::nonStaticFilter);
        System.out.println("C. Non-Static Method   : " + listC);

        // D. Declared Lambda Expression
        List<Product> listD = getProducts();
        Predicate<Product> predicate = p -> p.getPrice() >= 100.0;
        listD.removeIf(predicate);
        System.out.println("D. Declared Lambda     : " + listD);

        // E. Inline Lambda Expression
        List<Product> listE = getProducts();
        listE.removeIf(p -> p.getPrice() >= 100.0);
        System.out.println("E. Inline Lambda       : " + listE);
        System.out.println();
    }

    private static void exampleUseConsumer() {
        System.out.println("==================================================");
        System.out.println("           3. USE CONSUMER [ T -> void ]          ");
        System.out.println("==================================================");

        double factor = 1.1;

        // A. Interface Implementation
        List<Product> listA = getProducts();
        listA.forEach(new ProductPriceUpdateConsumer());
        System.out.println("A. Interface Class     : " + listA.get(0));

        // B. Static Method Reference
        List<Product> listB = getProducts();
        listB.forEach(Product::staticPriceUpdate);
        System.out.println("B. Static Method Ref   : " + listB.get(0));

        // C. Non-Static Method Reference
        List<Product> listC = getProducts();
        listC.forEach(Product::nonStaticPriceUpdate);
        System.out.println("C. Non-Static Method   : " + listC.get(0));

        // D. Declared Lambda Expression
        List<Product> listD = getProducts();
        Consumer<Product> consumer = p -> p.setPrice(p.getPrice() * factor);
        listD.forEach(consumer);
        System.out.println("D. Declared Lambda     : " + listD.get(0));

        // E. Inline Lambda Expression
        List<Product> listE = getProducts();
        listE.forEach(p -> p.setPrice(p.getPrice() * factor));
        System.out.println("E. Inline Lambda       : " + listE.get(0));
        System.out.println();
    }

    private static void exampleUseFunction() {
        System.out.println("==================================================");
        System.out.println("            4. USE FUNCTION [ T -> R ]            ");
        System.out.println("==================================================");

        // A. Interface Implementation
        List<String> listA = getProducts().stream()
                .map(new ProductUpperCaseNameFunction())
                .collect(Collectors.toList());
        System.out.println("A. Interface Class     : " + listA);

        // B. Static Method Reference
        List<String> listB = getProducts().stream()
                .map(Product::staticUpperCaseName)
                .collect(Collectors.toList());
        System.out.println("B. Static Method Ref   : " + listB);

        // C. Non-Static Method Reference
        List<String> listC = getProducts().stream()
                .map(Product::nonStaticUpperCaseName)
                .collect(Collectors.toList());
        System.out.println("C. Non-Static Method   : " + listC);

        // D. Declared Lambda Expression
        Function<Product, String> function = p -> p.getName().toUpperCase();
        List<String> listD = getProducts().stream()
                .map(function)
                .collect(Collectors.toList());
        System.out.println("D. Declared Lambda     : " + listD);

        // E. Inline Lambda Expression
        List<String> listE = getProducts().stream()
                .map(p -> p.getName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("E. Inline Lambda       : " + listE);
        System.out.println();
    }

    private static void exampleUseSupplier() {
        System.out.println("==================================================");
        System.out.println("  5. USE SUPPLIER & DoubleSupplier [ () -> T/double ] ");
        System.out.println("==================================================");

        List<Product> products = getProducts();

        // A. Interface Implementation
        Supplier<Double> customSupplier = new ProductRandomPriceSupplier();
        List<Product> listA = products.stream()
                .map(p -> new Product(p.getName(), customSupplier.get()))
                .collect(Collectors.toList());
        System.out.println("A. Interface Supplier Result : " + listA.get(0));

        // B. Specialized Primitive Supplier (DoubleSupplier)
        DoubleSupplier randomDoubleSupplier = () -> 5.0 + (Math.random() * (500.0 - 5.0));
        Function<Product, Product> mapper = p -> new Product(p.getName(), randomDoubleSupplier.getAsDouble());

        List<Product> listB = products.stream()
                .map(mapper)
                .collect(Collectors.toList());
        System.out.println("B. Primitive Supplier Result : " + listB.get(0));
        System.out.println();
    }

    private static void exampleHigherOrderFunction() {
        System.out.println("==================================================");
        System.out.println("   6. HIGHER-ORDER FUNCTION [ (..., f(x)) -> R ]  ");
        System.out.println("==================================================");

        List<Product> products = getProducts();
        ProductService service = new ProductService();

        // Passing criteria dynamically via lambda (Products starting with 'T')
        double filteredSum = service.filteredSum(products, p -> p.getName().startsWith("T"));
        System.out.println("Sum of products starting with 'T': $" + String.format("%.2f", filteredSum));
    }

    private static void exampleCustomFunctionalInterface() {
        System.out.println("==================================================");
        System.out.println(" 7. CUSTOM FUNCTIONAL INTERFACE [ Product -> R ] ");
        System.out.println("==================================================");

        List<Product> products = getProducts();
        Product sampleProduct = products.get(0); // TV - $500.00

        // A. Interface Implementation
        ProductTransformer<Double> impl = new ProductDiscountTransformer();
        System.out.println("A. Interface Class     : Price with 15% discount = $" + impl.transform(sampleProduct));

        // B. Declared Lambda Expression
        ProductTransformer<Double> taxCalculator = p -> p.getPrice() * 1.12; // 12% tax
        System.out.println("D. Declared Lambda     : Price with 12% tax = $" + taxCalculator.transform(sampleProduct));

        // C. Inline Lambda Expression (Passed directly into a higher-order method)
        String formattedLabel = formatProduct(sampleProduct, p -> "PROMO: " + p.getName() + " for $" + p.getPrice());
        System.out.println("E. Inline Lambda       : " + formattedLabel);
        System.out.println();
    }

    // Helper higher-order method that accepts our custom interface
    private static <R> R formatProduct(Product p, ProductTransformer<R> transformer) {
        return transformer.transform(p);
    }
}