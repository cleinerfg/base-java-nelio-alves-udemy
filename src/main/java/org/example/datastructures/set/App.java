package org.example.datastructures.set;

import java.util.*;

/**
 * <h1>Quick Comparison of the 3 Main Set Implementations</h1>
 *
 * <table border="1" cellpadding="6" cellspacing="0">
 *   <tr>
 *     <th align="left">Implementation</th>
 *     <th align="left">Ordering</th>
 *     <th align="left">Performance</th>
 *     <th align="left">Internal Structure</th>
 *     <th align="left">Null Support</th>
 *   </tr>
 *   <tr>
 *     <td nowrap style="white-space:nowrap;"><b>1. HashSet</b></td>
 *     <td><code>Unordered</code> (arbitrary sequence)</td>
 *     <td><code>O(1)</code> for basic operations</td>
 *     <td>Hash table</td>
 *     <td>Allows one <code>null</code></td>
 *   </tr>
 *   <tr>
 *     <td nowrap style="white-space:nowrap;"><b>2. LinkedHashSet</b></td>
 *     <td><code>Insertion-order</code> (maintains sequence)</td>
 *     <td><code>O(1)</code> (slightly higher overhead)</td>
 *     <td>Hash table + Doubly-linked list</td>
 *     <td>Allows one <code>null</code></td>
 *   </tr>
 *   <tr>
 *     <td nowrap style="white-space:nowrap;"><b>3. TreeSet</b></td>
 *     <td><code>Sorted</code> (natural or Comparator)</td>
 *     <td><code>O(log n)</code> for basic operations</td>
 *     <td>Red-Black tree (NavigableMap)</td>
 *     <td><b>No nulls</b> (throws <code>NullPointerException</code>)</td>
 *   </tr>
 * </table>
 */
public class App {

    public static void main(String[] args) {
        explainSetTypes();
        exampleBasicOperations();
        exampleMathematicalOperations();
        exampleUtilityMethods();
        exampleImmutableSet();
        exampleProductEquality();
        exampleTreeSetNaturalOrder();
        exampleTreeSetCustomComparator();

    }

    private static void explainSetTypes() {
        System.out.println("==================================================");
        System.out.println("       1. COMPARING SET IMPLEMENTATIONS           ");
        System.out.println("==================================================");

        // HashSet: Random order
        Set<String> hashSet = new HashSet<>(Arrays.asList("Banana", "Apple", "Orange", "Mango"));
        System.out.println("HashSet (Unordered)       : " + hashSet);

        // LinkedHashSet: Insertion order preserved
        Set<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("Banana", "Apple", "Orange", "Mango"));
        System.out.println("LinkedHashSet (Inserted)  : " + linkedHashSet);

        // TreeSet: Sorted alphabetically / naturally
        Set<String> treeSet = new TreeSet<>(Arrays.asList("Banana", "Apple", "Orange", "Mango"));
        System.out.println("TreeSet (Sorted)          : " + treeSet);
        System.out.println();
    }

    private static void exampleBasicOperations() {
        System.out.println("==================================================");
        System.out.println("       2. BASIC SET OPERATIONS (HashSet)          ");
        System.out.println("==================================================");

        Set<String> products = new HashSet<>();

        // add() - adds an element if not already present
        products.add("Television");
        products.add("Tablet");
        products.add("Notebook");

        // Duplicate addition attempt returns false and is ignored
        boolean isAddedAgain = products.add("Tablet");
        System.out.println("Was duplicate 'Tablet' added? " + isAddedAgain);

        // contains() - checks if an element exists
        System.out.println("Contains 'TV'? " + products.contains("TV"));
        System.out.println("Contains 'Tablet'? " + products.contains("Tablet"));

        // remove() - removes an element
        products.remove("Television");
        System.out.println("After removing 'Television': " + products);

        // size() and isEmpty()
        System.out.println("Set size: " + products.size());
        System.out.println("Is set empty? " + products.isEmpty());

        System.out.println("Iterating over elements:");
        for (String product : products) {
            System.out.println(" - " + product);
        }
        System.out.println();
    }

    private static void exampleMathematicalOperations() {
        System.out.println("==================================================");
        System.out.println("       3. SET ALGEBRA / BULK OPERATIONS           ");
        System.out.println("==================================================");

        Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 6, 8, 10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);

        // Union - combines all unique elements from both sets
        Set<Integer> union = new TreeSet<>(a);
        union.addAll(b);
        System.out.println("Union (A ∪ B)        : " + union);

        // Intersection - retains only elements present in both sets
        Set<Integer> intersection = new TreeSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection (A ∩ B) : " + intersection);

        // Difference - removes elements present in set B from set A
        Set<Integer> difference = new TreeSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference (A - B)   : " + difference);

        // Subset check
        boolean containsAll = a.containsAll(Arrays.asList(2, 4, 6));
        System.out.println("Does A contain {2, 4, 6}? " + containsAll);
        System.out.println();
    }

    private static void exampleUtilityMethods() {
        System.out.println("==================================================");
        System.out.println("       4. ADDITIONAL COMMON UTILITIES             ");
        System.out.println("==================================================");

        Set<String> colors = new HashSet<>(Arrays.asList("Red", "Green", "Blue"));

        // Convert Set to Array
        String[] colorArray = colors.toArray(new String[0]);
        System.out.println("Converted to Array: " + Arrays.toString(colorArray));

        // removeIf() - conditional removal via predicate (Java 8+)
        colors.removeIf(color -> color.startsWith("G"));
        System.out.println("After removing colors starting with 'G': " + colors);

        // clear() - removes all elements
        colors.clear();
        System.out.println("After clear(): " + colors);
        System.out.println("Is empty now? " + colors.isEmpty());
        System.out.println("==================================================");
    }

    private static void exampleImmutableSet() {
        System.out.println("==================================================");
        System.out.println("       5. IMMUTABLE SET (Set.of)                  ");
        System.out.println("==================================================");

        // Set.of() creates an unmodifiable/immutable set (Java 9+)
        Set<String> roles = Set.of("ADMIN", "USER", "GUEST");
        System.out.println("Immutable Set: " + roles);

        // Elements cannot be null (throws NullPointerException)
        // Duplicates are strictly rejected at creation time (throws IllegalArgumentException)
        // Modifying operations throw UnsupportedOperationException
        try {
            roles.add("MANAGER");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable set: " + e.getClass().getSimpleName());
        }

        // Under the hood, Java uses optimized internal classes like ImmutableCollections$SetN
        System.out.println("Concrete class type: " + roles.getClass().getName());

        // Passing Set.of() into HashSet constructor creates a fully mutable HashSet
        Set<String> mutableRoles = new HashSet<>(Set.of("ADMIN", "USER", "GUEST"));

        // Operations now work normally on the new HashSet
        mutableRoles.add("MANAGER");
        mutableRoles.remove("GUEST");
        System.out.println("Mutable HashSet created via Set.of(): " + mutableRoles);
        System.out.println();
    }

    /**
     * <h1>SUMMARY OF HOW SET TESTS EQUALITY (HashSet / LinkedHashSet)</h1>
     *
     * <ol>
     *   <li><b>hashCode():</b> Determines the memory bucket where the element should reside.</li>
     *   <li><b>Empty Bucket Check:</b> If the bucket is empty, the element is inserted immediately without calling <code>equals()</code>.</li>
     *   <li><b>Hash Collision:</b> If a collision occurs (same bucket), Set calls <code>equals()</code> against elements in that bucket.</li>
     *   <li><b>Duplicate Detection:</b> If <code>equals()</code> returns <font color="#2e7d32"><b>true</b></font>, the element is considered a duplicate and <font color="#c62828"><b>rejected</b></font>.</li>
     *   <li><b>New Element Insertion:</b> If <code>equals()</code> returns <font color="#c62828"><b>false</b></font>, the new element is added to the bucket (as a linked list or tree node).</li>
     * </ol>
     *
     * <hr>
     * <h2><font color="#e65100">IMPORTANT — Default Object Behavior</font></h2>
     * <ul>
     *   <li><b>Missing Overrides:</b> If <code>hashCode()</code> and <code>equals()</code> are <i>NOT</i> overridden in your custom class, Java inherits default implementations from <code>java.lang.Object</code>.</li>
     *   <li><b>Default hashCode():</b> Generates an integer derived from the object's internal memory address.</li>
     *   <li><b>Default equals():</b> Performs an <u>identity/reference comparison</u> (<code>this == obj</code>), checking if both variables point to the exact same <b>memory pointer location</b>.</li>
     *   <li><b>Consequence:</b> Two distinct instances with identical field values will be treated as separate, unique elements, <font color="#c62828"><b>allowing duplicates to be inserted into the Set</b></font>.</li>
     * </ul>
     */
    private static void exampleProductEquality() {
        System.out.println("==================================================");
        System.out.println("           PRODUCT EQUALITY IN HASHSET             ");
        System.out.println("==================================================");

        Set<Product> products = new HashSet<>();

        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(102, "Smartphone");

        // Same ID as p1, but different name
        Product p3 = new Product(101, "Laptop Pro Edition");

        // 1. Adding unique products
        System.out.println("Added p1 (ID 101): " + products.add(p1)); // true
        System.out.println("Added p2 (ID 102): " + products.add(p2)); // true

        // 2. Attempting to add p3 (Same ID 101)
        boolean isP3Added = products.add(p3);
        System.out.println("Added p3 (Duplicate ID 101)? " + isP3Added); // false

        // 3. Testing contains() with a new object instance holding an existing ID
        Product searchKey = new Product(102, "Dummy Search Name");
        System.out.println("Set contains ID 102? " + products.contains(searchKey)); // true

        System.out.println("\nFinal Set contents (Size = " + products.size() + "):");
        for (Product product : products) {
            System.out.println(" - " + product);
        }
        System.out.println("==================================================");
    }

    /**
     * <h1>SUMMARY OF HOW TreeSet EQUALITY & ORDERING</h1>
     *
     * <ul>
     *   <li><b>Comparison Mechanism:</b> TreeSet does <i>NOT</i> use <code>hashCode()</code> or <code>equals()</code> to check for duplicates.</li>
     *   <li><b>Tree Traversal:</b> It uses <code>Comparable.compareTo()</code> or a custom <code>Comparator.compare()</code> while navigating its Red-Black tree.</li>
     *   <li><b>Equality Rule:</b> Two elements are considered equal if <code>compare(a, b) == 0</code>.</li>
     *   <li><b>Duplicate Handling:</b> If the comparison returns <code>0</code>, the element is recognized as a duplicate and <font color="#c62828"><b>rejected</b></font>.</li>
     *   <li><b>Sorting Rule:</b> If comparison is <code>&lt; 0</code>, the node goes to the left branch; if <code>&gt; 0</code>, it goes to the right branch.</li>
     * </ul>
     *
     * <hr>
     * <h2>IMPORTANT — TreeSet vs HashSet Differences</h2>
     * <ul>
     *   <li><b>No Nulls Allowed:</b> Attempting to add <code>null</code> throws a <code>NullPointerException</code> because comparison methods cannot be called on <code>null</code>.</li>
     *   <li><b>Inconsistency with equals():</b> If <code>compareTo() == 0</code> returns true for two objects, but <code>equals()</code> returns false, <code>TreeSet</code> will still treat them as identical and reject the second insertion.</li>
     * </ul>
     */

    private static void exampleTreeSetNaturalOrder() {
        System.out.println("==================================================");
        System.out.println("        1.0 TREESET WITH NATURAL ORDERING (ID)      ");
        System.out.println("==================================================");

        Set<Product> products = new TreeSet<>();

        Product p1 = new Product(103, "Monitor");
        Product p2 = new Product(101, "Keyboard");
        Product p3 = new Product(102, "Mouse");

        // Same ID 101 as p2, but different name
        Product p4 = new Product(101, "Mechanical Keyboard");

        products.add(p1);
        products.add(p2);
        products.add(p3);

        // Attempting to add p4 (returns false because compareTo(p2, p4) == 0)
        boolean isAdded = products.add(p4);
        System.out.println("Was duplicate ID 101 added? " + isAdded); // false

        System.out.println("\nSorted Products (automatically ordered by ID):");
        for (Product product : products) {
            System.out.println(" - " + product);
        }
        System.out.println();
    }

    private static void exampleTreeSetCustomComparator() {
        System.out.println("==================================================");
        System.out.println("    2. TREESET WITH CUSTOM COMPARATOR (NAME)      ");
        System.out.println("==================================================");

        // Comparator ordering alphabetically by name instead of ID
        Set<Product> productsByName = new TreeSet<>(Comparator.comparing(Product::getName));

        productsByName.add(new Product(103, "Monitor"));
        productsByName.add(new Product(101, "Keyboard"));
        productsByName.add(new Product(102, "Mouse"));

        // Same name as an existing product, but different ID
        Product pDuplicateName = new Product(999, "Mouse");
        boolean isAdded = productsByName.add(pDuplicateName);
        System.out.println("Was duplicate Name 'Mouse' added? " + isAdded); // false

        System.out.println("\nSorted Products (ordered alphabetically by Name):");
        for (Product product : productsByName) {
            System.out.println(" - " + product);
        }
        System.out.println("==================================================");
    }
}