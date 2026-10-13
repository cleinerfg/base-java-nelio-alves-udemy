package org.example.datastructures.map;

import java.util.*;

/**
 * <h1>Quick Comparison of the 3 Main Map Implementations</h1>
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
 *     <td nowrap style="white-space:nowrap;"><b>1. HashMap</b></td>
 *     <td><code>Unordered</code> (arbitrary sequence)</td>
 *     <td><code>O(1)</code> for basic operations</td>
 *     <td>Hash table (Array of buckets + Linked List / Red-Black Tree)</td>
 *     <td>Allows <b>one null key</b> and multiple null values</td>
 *   </tr>
 *   <tr>
 *     <td nowrap style="white-space:nowrap;"><b>2. LinkedHashMap</b></td>
 *     <td><code>Insertion-order</code> (or access-order)</td>
 *     <td><code>O(1)</code> (slightly higher overhead)</td>
 *     <td>Hash table + Doubly-linked list across entries</td>
 *     <td>Allows <b>one null key</b> and multiple null values</td>
 *   </tr>
 *   <tr>
 *     <td nowrap style="white-space:nowrap;"><b>3. TreeMap</b></td>
 *     <td><code>Sorted</code> (natural order or Comparator)</td>
 *     <td><code>O(log n)</code> for basic operations</td>
 *     <td>Red-Black tree (NavigableMap)</td>
 *     <td><b>No null keys</b> (throws <code>NullPointerException</code>); allows null values</td>
 *   </tr>
 * </table>
 */
public class App {

    public static void main(String[] args) {
        explainMapTypes();
        exampleBasicOperations();
        exampleBulkAndComputeOperations();
        exampleUtilityMethods();
        exampleImmutableMap();
        exampleKeyEqualityInHashMap();
        exampleTreeMapNaturalOrder();
        exampleTreeMapCustomComparator();
    }

    private static void explainMapTypes() {
        System.out.println("==================================================");
        System.out.println("       1. COMPARING MAP IMPLEMENTATIONS           ");
        System.out.println("==================================================");

        // HashMap: Arbitrary order
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Banana", 10);
        hashMap.put("Apple", 20);
        hashMap.put("Orange", 15);
        hashMap.put("Mango", 25);
        System.out.println("HashMap (Unordered)       : " + hashMap);

        // LinkedHashMap: Insertion order preserved
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Banana", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Orange", 15);
        linkedHashMap.put("Mango", 25);
        System.out.println("LinkedHashMap (Inserted)  : " + linkedHashMap);

        // TreeMap: Sorted by keys
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 10);
        treeMap.put("Apple", 20);
        treeMap.put("Orange", 15);
        treeMap.put("Mango", 25);
        System.out.println("TreeMap (Sorted by Keys)  : " + treeMap);
        System.out.println();
    }

    private static void exampleBasicOperations() {
        System.out.println("==================================================");
        System.out.println("       2. BASIC MAP OPERATIONS (HashMap)          ");
        System.out.println("==================================================");

        Map<String, Double> products = new HashMap<>();

        // put() - inserts or updates a key-value pair
        products.put("Television", 1200.0);
        products.put("Tablet", 300.0);
        products.put("Notebook", 1500.0);

        // Overwriting an existing key returns the old value
        Double oldVal = products.put("Tablet", 350.0);
        System.out.println("Previous price for 'Tablet': " + oldVal);
        System.out.println("Updated 'Tablet' price: " + products.get("Tablet"));

        // get() and getOrDefault()
        System.out.println("Price of 'Notebook': " + products.get("Notebook"));
        System.out.println("Price of 'Smartphone' (Default): " + products.getOrDefault("Smartphone", 0.0));

        // containsKey() and containsValue()
        System.out.println("Contains key 'Television'? " + products.containsKey("Television"));
        System.out.println("Contains value 1500.0? " + products.containsValue(1500.0));

        // remove() - removes by key or by key-value pair
        products.remove("Television");
        System.out.println("After removing 'Television': " + products);

        // size() and isEmpty()
        System.out.println("Map size: " + products.size());
        System.out.println("Is map empty? " + products.isEmpty());

        System.out.println("Iterating over entries (EntrySet):");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println();
    }

    private static void exampleBulkAndComputeOperations() {
        System.out.println("==================================================");
        System.out.println("       3. ADVANCED MANIPULATIONS (Java 8+)        ");
        System.out.println("==================================================");

        Map<String, Integer> stock = new HashMap<>();
        stock.put("Laptop", 5);
        stock.put("Mouse", 20);

        System.out.println("Initial Stock: " + stock);

        // putIfAbsent() - inserts only if key is missing or mapped to null
        stock.putIfAbsent("Laptop", 10); // Ignored
        stock.putIfAbsent("Keyboard", 15); // Added
        System.out.println("After putIfAbsent: " + stock);

        // computeIfAbsent() - computes value if key is not present
        stock.computeIfAbsent("Monitor", key -> key.length() * 2);
        System.out.println("After computeIfAbsent ('Monitor'): " + stock);

        // computeIfPresent() - recalculates value if key exists
        stock.computeIfPresent("Mouse", (key, oldVal) -> oldVal + 10);
        System.out.println("After computeIfPresent ('Mouse' + 10): " + stock);

        // merge() - combines existing value with new value
        stock.merge("Mouse", 5, Integer::sum);
        stock.merge("Headphone", 8, Integer::sum);
        System.out.println("After merge operations: " + stock);
        System.out.println();
    }

    private static void exampleUtilityMethods() {
        System.out.println("==================================================");
        System.out.println("       4. ADDITIONAL COMMON UTILITIES             ");
        System.out.println("==================================================");

        Map<String, String> capitalMap = new HashMap<>();
        capitalMap.put("Brazil", "Brasilia");
        capitalMap.put("France", "Paris");
        capitalMap.put("Japan", "Tokyo");

        // keySet(), values(), entrySet()
        System.out.println("Keys Set: " + capitalMap.keySet());
        System.out.println("Values Collection: " + capitalMap.values());

        // forEach() - internal iteration
        System.out.println("Iterating with forEach:");
        capitalMap.forEach((country, capital) -> System.out.println(" - " + country + " -> " + capital));

        // replaceAll() - applies transformation function to all values
        capitalMap.replaceAll((country, capital) -> capital.toUpperCase());
        System.out.println("After replaceAll (Uppercase): " + capitalMap);

        // clear() - wipes out all entries
        capitalMap.clear();
        System.out.println("After clear(): " + capitalMap);
        System.out.println("Is empty now? " + capitalMap.isEmpty());
        System.out.println("==================================================");
    }

    private static void exampleImmutableMap() {
        System.out.println("==================================================");
        System.out.println("       5. IMMUTABLE MAP (Map.of / Map.ofEntries)  ");
        System.out.println("==================================================");

        // Map.of() creates an unmodifiable/immutable map (Java 9+)
        Map<String, String> config = Map.of(
                "env", "production",
                "timeout", "5000"
        );
        System.out.println("Immutable Map: " + config);

        // Keys and values CANNOT be null (throws NullPointerException)
        // Duplicate keys are rejected at creation (throws IllegalArgumentException)
        // Modifying operations throw UnsupportedOperationException
        try {
            config.put("debug", "true");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable map: " + e.getClass().getSimpleName());
        }

        // Under the hood, Java uses optimized internal representations
        System.out.println("Concrete class type: " + config.getClass().getName());

        // Wrapping inside HashMap creates a fully mutable Map
        Map<String, String> mutableConfig = new HashMap<>(config);
        mutableConfig.put("debug", "true");
        System.out.println("Mutable HashMap created via Map.of(): " + mutableConfig);
        System.out.println();
    }

    /**
     * <h1>SUMMARY OF HOW HASHMAP TESTS KEY EQUALITY</h1>
     *
     * <ol>
     *   <li><b>hashCode():</b> Calculates key bucket index using key's hash code.</li>
     *   <li><b>Empty Bucket Check:</b> If bucket is empty, key-value entry is stored directly.</li>
     *   <li><b>Hash Collision:</b> If bucket is occupied, HashMap compares keys in that bucket using <code>hashCode()</code> and <code>equals()</code>.</li>
     *   <li><b>Duplicate Key Detection:</b> If <code>equals()</code> returns <font color="#2e7d32"><b>true</b></font>, key exists and value is updated/replaced.</li>
     *   <li><b>New Key Insertion:</b> If <code>equals()</code> returns <font color="#c62828"><b>false</b></font>, entry is appended as a node.</li>
     * </ol>
     *
     * <hr>
     * <h2><font color="#e65100">IMPORTANT — Default Object Behavior</font></h2>
     * <ul>
     *   <li><b>Missing Overrides:</b> If <code>hashCode()</code> and <code>equals()</code> are not overridden in custom key classes, Java uses reference comparison (<code>this == obj</code>).</li>
     *   <li><b>Consequence:</b> Two distinct key instances with identical attributes will be treated as separate keys, resulting in unexpected duplicate entries.</li>
     * </ul>
     */
    private static void exampleKeyEqualityInHashMap() {
        System.out.println("==================================================");
        System.out.println("           KEY EQUALITY IN HASHMAP                ");
        System.out.println("==================================================");

        Map<ProductKey, String> inventoryLocation = new HashMap<>();

        ProductKey k1 = new ProductKey(101, "SKU-A");
        ProductKey k2 = new ProductKey(102, "SKU-B");
        // Same ID and SKU as k1
        ProductKey k3 = new ProductKey(101, "SKU-A");

        inventoryLocation.put(k1, "Warehouse A - Shelf 1");
        inventoryLocation.put(k2, "Warehouse B - Shelf 4");

        System.out.println("Map size before duplicate put: " + inventoryLocation.size()); // 2

        // Replacing value for identical key
        inventoryLocation.put(k3, "Warehouse A - Shelf 9 (Updated)");
        System.out.println("Map size after duplicate key put: " + inventoryLocation.size()); // Still 2

        System.out.println("Lookup using new key instance (k3): " + inventoryLocation.get(k3));

        System.out.println("\nFinal Map contents:");
        inventoryLocation.forEach((key, location) -> System.out.println(" - " + key + " => " + location));
        System.out.println("==================================================");
    }

    /**
     * <h1>SUMMARY OF TREEMAP EQUALITY & ORDERING</h1>
     *
     * <ul>
     *   <li><b>Comparison Mechanism:</b> TreeMap does <i>NOT</i> use <code>hashCode()</code> or <code>equals()</code> for key comparison.</li>
     *   <li><b>Tree Traversal:</b> Key comparison relies on <code>Comparable.compareTo()</code> or a <code>Comparator.compare()</code>.</li>
     *   <li><b>Equality Rule:</b> Keys are considered equal if <code>compare(k1, k2) == 0</code>.</li>
     *   <li><b>Duplicate Handling:</b> If comparison returns <code>0</code>, key is considered a match and value is overwritten.</li>
     * </ul>
     */
    private static void exampleTreeMapNaturalOrder() {
        System.out.println("==================================================");
        System.out.println("        1. TREEMAP NATURAL KEY ORDERING           ");
        System.out.println("==================================================");

        // ProductKey implements Comparable<ProductKey> based on ID
        Map<ProductKey, Double> priceMap = new TreeMap<>();

        ProductKey k1 = new ProductKey(103, "SKU-C");
        ProductKey k2 = new ProductKey(101, "SKU-A");
        ProductKey k3 = new ProductKey(102, "SKU-B");
        ProductKey k4 = new ProductKey(101, "SKU-A-DuplicateID");

        priceMap.put(k1, 299.99);
        priceMap.put(k2, 49.99);
        priceMap.put(k3, 89.99);

        // Attempting to insert duplicate ID key (overwrites value of k2)
        priceMap.put(k4, 59.99);

        System.out.println("Sorted Map Entries (Ordered naturally by ProductKey ID):");
        priceMap.forEach((key, price) -> System.out.println(" - " + key + " : $" + price));
        System.out.println();
    }

    private static void exampleTreeMapCustomComparator() {
        System.out.println("==================================================");
        System.out.println("    2. TREEMAP WITH CUSTOM KEY COMPARATOR         ");
        System.out.println("==================================================");

        // Comparator sorting keys by SKU alphabetically instead of ID
        Map<ProductKey, Double> priceMapBySku = new TreeMap<>(Comparator.comparing(ProductKey::getSku));

        priceMapBySku.put(new ProductKey(103, "SKU-C"), 299.99);
        priceMapBySku.put(new ProductKey(101, "SKU-A"), 49.99);
        priceMapBySku.put(new ProductKey(102, "SKU-B"), 89.99);

        System.out.println("Sorted Map Entries (Ordered alphabetically by SKU):");
        priceMapBySku.forEach((key, price) -> System.out.println(" - " + key + " : $" + price));
        System.out.println("==================================================");
    }

}