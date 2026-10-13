package org.example.projects.userlogs.entities;

import java.time.Instant;
import java.util.Objects;

public class Log {

    private String username;
    private Instant createdAt;

    public Log(String username, Instant createdAt) {
        this.username = username;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Log{" +
                "username='" + username + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Log log)) return false;
        return Objects.equals(username, log.username) && Objects.equals(createdAt, log.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, createdAt);
    }
}
