package org.example.projects.userlogs;

import org.example.projects.userlogs.entities.Log;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        String inputData = """
                amanda 2026-08-28T20:45:08Z
                alex89 2026-08-28T21:10:00Z
                amanda 2026-08-28T22:00:15Z
                brian 2026-08-28T22:30:00Z
                maria_s 2026-08-28T23:12:40Z
                alex89 2026-08-29T08:05:00Z
                amanda 2026-08-29T09:15:30Z
                brian 2026-08-29T10:00:00Z
                """;

        Set<Log> logs = new LinkedHashSet<>();

        String[] lines = inputData.split("\n");

        for (String line : lines) {
            if (!line.isBlank()) {
                String[] fields = line.trim().split(" ");
                String username = fields[0];
                Instant createdAt = Instant.parse(fields[1]);

                logs.add(new Log(username, createdAt));
            }
        }

        Set<String> distinctUsernames = logs.stream()
                .map(Log::getUsername)
                .collect(Collectors.toSet());

        System.out.println("Total records read: " + logs.size());
        System.out.println("Total distinct users: " + distinctUsernames.size());
        System.out.println("Distinct users: " + distinctUsernames);
    }
}