package org.example;

public class BitwiseSummary {

    public static void main(String[] args) {
        /*
         * WHY POWERS OF 2 (1, 2, 4, 8) INSTEAD OF (1, 2, 3)?
         * --------------------------------------------------
         * In binary, each flag MUST occupy a single unique bit:
         * 1 = 0001 (Bit 1)
         * 2 = 0010 (Bit 2)
         * 4 = 0100 (Bit 3)
         * 8 = 1000 (Bit 4)
         *
         * If we used 3 (0011), it would activate BOTH Bit 1 and Bit 2 at once,
         * falsely triggering both READ (1) and WRITE (2) permissions!
         */
        int READ = 0b0001; // Decimal 1 (2^0) - 1st bit
        int WRITE = 0b0010; // Decimal 2 (2^1) - 2nd bit
        int EXEC = 0b0100; // Decimal 4 (2^2) - 3rd bit
        int DELETE = 0b1000; // Decimal 8 (2^3) - 4th bit

        // 1. OR (|) -> COMBINE / ENABLE FLAGS
        int userPerms = READ | WRITE; // 0001 | 0010 = 0011 (Decimal 3 = READ + WRITE)
        System.out.println("Combined flags (READ | WRITE): " + userPerms);

        // 2. AND (&) -> CHECK IF FLAG IS ACTIVE
        boolean canWrite = (userPerms & WRITE) != 0; // 0011 & 0010 != 0 -> true
        boolean canExec = (userPerms & EXEC) != 0; // 0011 & 0100 != 0 -> false
        boolean canDelete = (userPerms & DELETE) != 0; // 0011 & 1000 != 0 -> false
        System.out.println("Has WRITE permission?  " + canWrite);
        System.out.println("Has EXEC permission?   " + canExec);
        System.out.println("Has DELETE permission? " + canDelete);

        // 3. XOR (^) -> TOGGLE & CANCEL EQUAL VALUES
        // Toggle: Flipping WRITE bit (ON -> OFF)
        userPerms = userPerms ^ WRITE; // 0011 ^ 0010 = 0001 (1)
        System.out.println("After XOR WRITE (Turned OFF): " + userPerms);

        // Cancelation: A ^ A = 0 (Find unique element in array)
        int[] numbers = {5, 2, 5}; // 2 has no pair
        int unique = 0;
        for (int num : numbers) {
            unique ^= num; // 5^5 cancels out to 0, leaves 2
        }
        System.out.println("Unique number in {5, 2, 5}: " + unique);

        // 4. NOT (~) -> INVERT ALL BITS
        int inverted = ~READ; // 0001 -> ...11111110 (-2)
        System.out.println("NOT READ (~1): " + inverted);

        // 5. SHIFTS (<<, >>) -> MULTIPLY / DIVIDE BY POWERS OF 2
        System.out.println("5 << 1 (5 * 2): " + (5 << 1)); // 10
        System.out.println("5 >> 1 (5 / 2): " + (5 >> 1)); // 2
    }
}
