package org.example.summary;

public class StringMethodsSummary {

    public static void main(String[] args) {
        String str = " Hello, Java World! ";

        System.out.println("--- 1. INSPECTION & LENGTH ---");
        System.out.println("Length: " + str.length()); // 20
        System.out.println("Is Empty? " + str.isEmpty()); // false
        System.out.println("Is Blank? " + "".isBlank()); // true (checks if empty or whitespace-only)
        System.out.println("Char at index 2: " + str.charAt(2)); // 'e'

        System.out.println("\n--- 2. SEARCHING & FINDING ---");
        System.out.println("Contains 'Java': " + str.contains("Java")); // true
        System.out.println("Starts with ' Hello': " + str.startsWith(" Hello")); // true
        System.out.println("Ends with 'World! ': " + str.endsWith("World! ")); // true
        System.out.println("Index of 'o': " + str.indexOf('o')); // 5 (first occurrence)
        System.out.println("Last index of 'o': " + str.lastIndexOf('o')); // 15

        System.out.println("\n--- 3. TRANSFORMING & CLEANING ---");
        System.out.println("Upper: " + str.toUpperCase()); // " HELLO, JAVA WORLD! "
        System.out.println("Lower: " + str.toLowerCase()); // " hello, java world! "
        System.out.println("Trim: '" + str.trim() + "'"); // "Hello, Java World!"
        System.out.println("Replace: " + str.replace("Java", "Spring")); // " Hello, Spring World! "

        System.out.println("\n--- 4. SUBSTRING & SPLITTING ---");
        String text = "Java,Python,Go";
        String[] languages = text.split(","); // Splits string into an array by delimiter
        System.out.println("First language: " + languages[0]); // "Java"
        System.out.println("Substring (0 to 4): " + text.substring(0, 4)); // "Java"

        System.out.println("\n--- 5. EQUALITY & COMPARISON ---");
        String a = "Java";
        String b = "java";
        System.out.println("Equals: " + a.equals(b)); // false (case-sensitive)
        System.out.println("Equals Ignore Case: " + a.equalsIgnoreCase(b)); // true

        System.out.println("\n--- 6. UTILITY METHODS ---");
        String joined = String.join("-", "2026", "10", "06"); // "2026-10-06"
        String formatted = String.format("User: %s | Score: %d", "Alice", 100);
        System.out.println("Joined: " + joined);
        System.out.println("Formatted: " + formatted); // User: Alice | Score: 100
    }
}