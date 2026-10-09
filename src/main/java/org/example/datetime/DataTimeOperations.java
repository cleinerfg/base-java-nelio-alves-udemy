package org.example.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DataTimeOperations {

    public static void main(String[] args) {
        showInstantiation();
        showParsing();
        showFormatting();
        showConversions();
        showZonedAndOffsetDateTime();
        showDateTimeArithmetic();
    }

    private static void showInstantiation() {
        System.out.println("==========================================");
        System.out.println("1. INSTANTIATION (CURRENT & CUSTOM)");
        System.out.println("==========================================");

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date & Time: " + currentDateTime);

        Instant currentInstant = Instant.now();
        System.out.println("Current Instant (UTC): " + currentInstant);

        LocalDate customDate = LocalDate.of(2023, 6, 20);
        System.out.println("Custom Date: " + customDate);

        LocalDateTime customDateTime = LocalDateTime.of(2023, 6, 20, 15, 30);
        System.out.println("Custom Date & Time: " + customDateTime);
    }

    private static void showParsing() {
        System.out.println("\n==========================================");
        System.out.println("2. STRING TO OBJECT (PARSING)");
        System.out.println("==========================================");

        LocalDate parsedIsoDate = LocalDate.parse("2023-06-20");
        System.out.println("Parsed ISO Date: " + parsedIsoDate);

        LocalDateTime parsedIsoDateTime = LocalDateTime.parse("2023-06-20T15:30:00");
        System.out.println("Parsed ISO Date & Time: " + parsedIsoDateTime);

        Instant parsedInstantUtc = Instant.parse("2023-06-20T15:30:00Z");
        System.out.println("Parsed Instant (UTC): " + parsedInstantUtc);

        Instant parsedInstantOffset = Instant.parse("2023-06-20T15:30:00-04:00");
        System.out.println("Parsed Instant (Offset to UTC): " + parsedInstantOffset);

        // Custom Format Parsing
        DateTimeFormatter customDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedCustomDate = LocalDate.parse("10/06/2023", customDateFormatter);
        System.out.println("Parsed Custom Date: " + parsedCustomDate);

        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime parsedCustomDateTime = LocalDateTime.parse("10/06/2025 01:45", customDateTimeFormatter);
        System.out.println("Parsed Custom Date & Time: " + parsedCustomDateTime);
    }

    private static void showFormatting() {
        System.out.println("\n==========================================");
        System.out.println("3. OBJECT TO STRING (FORMATTING)");
        System.out.println("==========================================");

        DateTimeFormatter customDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateToFormat = LocalDate.of(2024, 12, 25);
        System.out.println("Default Date Object: " + dateToFormat);
        String formattedDate = dateToFormat.format(customDateFormatter);
        System.out.println("Formatted Date: " + formattedDate);

        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTimeToFormat = LocalDateTime.of(2024, 12, 25, 20, 45);
        System.out.println("Default Date & Time Object: " + dateTimeToFormat);
        String formattedDateTime = dateTimeToFormat.format(customDateTimeFormatter);
        System.out.println("Formatted Date & Time: " + formattedDateTime);

        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("ISO Formatted Date & Time: " + dateTimeToFormat.format(isoFormatter));

        // Instant formatting with ZoneId
        Instant instantToFormat = Instant.now();
        DateTimeFormatter zoneFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z")
                .withZone(ZoneId.systemDefault());
        System.out.println("Formatted Instant (System Zone): " + zoneFormatter.format(instantToFormat));
    }

    private static void showConversions() {
        System.out.println("\n==========================================");
        System.out.println("4. CONVERSIONS BETWEEN TYPES");
        System.out.println("==========================================");

        LocalDate customDate = LocalDate.of(2023, 6, 20);
        LocalTime customTime = LocalTime.of(15, 30);
        LocalDateTime customDateTime = LocalDateTime.of(2023, 6, 20, 15, 30);
        Instant parsedInstantUtc = Instant.parse("2023-06-20T15:30:00Z");

        // LocalDate + LocalTime -> LocalDateTime
        LocalDateTime combinedDateTime = customDate.atTime(customTime);
        System.out.println("LocalDate + LocalTime to LocalDateTime: " + combinedDateTime);

        // LocalDateTime -> LocalDate / LocalTime
        LocalDate extractedDate = customDateTime.toLocalDate();
        LocalTime extractedTime = customDateTime.toLocalTime();
        System.out.println("Extracted Date: " + extractedDate);
        System.out.println("Extracted Time: " + extractedTime);

        // LocalDateTime -> Instant (requires ZoneOffset)
        Instant dateTimeToInstant = customDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println("LocalDateTime to Instant (System Zone): " + dateTimeToInstant);

        // Instant -> LocalDateTime (requires ZoneId)
        LocalDateTime instantToDateTime = LocalDateTime.ofInstant(parsedInstantUtc, ZoneId.systemDefault());
        System.out.println("Instant to LocalDateTime (System Zone): " + instantToDateTime);
    }

    private static void showZonedAndOffsetDateTime() {
        System.out.println("\n==========================================");
        System.out.println("5. ZONED & OFFSET DATE-TIME (TIMEZONE CONTEXT)");
        System.out.println("==========================================");

        // Instant: Pure UTC timestamp (Best for logs, system audit, database timestamps)
        // Discards local time context (e.g., store closing hour or local business date)
        Instant saleInstant = Instant.parse("2026-10-08T23:30:00Z");
        System.out.println("Sale Instant (UTC): " + saleInstant);

        // OffsetDateTime: Preserves UTC offset (-03:00, -04:00)
        // Essential for business operations (e.g., invoices, sales reports, regional store days)
        OffsetDateTime storeSaleOffset = OffsetDateTime.of(2026, 10, 8, 20, 30, 0, 0, ZoneOffset.ofHours(-3));
        System.out.println("Store Sale (Offset Preserved): " + storeSaleOffset);

        // Creating OffsetDateTime dynamically using a ZoneId (converts local time + zone to offset)
        LocalDateTime localDateTime = LocalDateTime.of(2026, 10, 8, 20, 30);
        ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
        OffsetDateTime offsetFromZone = localDateTime.atZone(zoneId).toOffsetDateTime();
        System.out.println("OffsetDateTime from ZoneId: " + offsetFromZone);

        // ZonedDateTime: Offset + Region ID with Daylight Saving Time (DST) rules
        // Used for complex regional calendar calculations
        ZonedDateTime regionalSaleZone = ZonedDateTime.of(2026, 10, 8, 20, 30, 0, 0, zoneId);
        System.out.println("Regional Sale (Zone & DST Rules): " + regionalSaleZone);

        // Convert OffsetDateTime -> Instant (Loses local offset info, converts directly to UTC timeline point)
        Instant offsetConvertedToInstant = storeSaleOffset.toInstant();
        System.out.println("Offset converted to Instant (UTC): " + offsetConvertedToInstant);
    }

    private static void showDateTimeArithmetic() {
        System.out.println("\n==========================================");
        System.out.println("6. DATE-TIME ARITHMETIC (ADD & SUBTRACT)");
        System.out.println("==========================================");

        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 20, 15, 30);
        System.out.println("Original Date & Time: " + dateTime);

        OffsetDateTime saleTime = OffsetDateTime.of(2024, 6, 20,
                15, 30, 0, 0, ZoneOffset.ofHours(-3)
        );
        System.out.println("Original Sale Time (Offset): " + saleTime);

        // Adding time
        LocalDateTime addedDays = dateTime.plusDays(5);
        LocalDateTime addedHours = dateTime.plusHours(3);
        System.out.println("After Adding 5 Days: " + addedDays);
        System.out.println("After Adding 3 Hours: " + addedHours);

        OffsetDateTime futureDelivery = saleTime.plusDays(5).plusHours(2);
        System.out.println("Delivery (+5 days, +2 hours): " + futureDelivery);

        Instant now = Instant.now();
        Instant futureInstant = now.plusSeconds(3600);
        System.out.println("Future Instant (+1 hour): " + futureInstant);

        // Subtracting time
        LocalDateTime subtractedDays = dateTime.minusDays(2);
        LocalDateTime subtractedMinutes = dateTime.minusMinutes(45);
        System.out.println("After Subtracting 2 Days: " + subtractedDays);
        System.out.println("After Subtracting 45 Minutes: " + subtractedMinutes);

        OffsetDateTime pastAudit = saleTime.minusYears(1).minusDays(10);
        System.out.println("Past Audit (-1 year, -10 days): " + pastAudit);

        Instant pastInstant = now.minus(10, ChronoUnit.DAYS);
        System.out.println("Past Instant (-10 days): " + pastInstant);

        // Duration and Period
        Duration durationBetween = Duration.between(dateTime, addedDays);
        System.out.println("Duration between original and added days: " + durationBetween.toHours() + " hours");

        Period periodBetween = Period.between(dateTime.toLocalDate(), addedDays.toLocalDate());
        System.out.println("Period between original and added days: " + periodBetween.getDays() + " days");

        Duration durationBetweenInstants = Duration.between(now, futureInstant);
        System.out.println("Duration between now and future instant: " + durationBetweenInstants.toHours() + " hours");
    }
}