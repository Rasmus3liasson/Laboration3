package org.laboration3.entities;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public record Product(int id, String name, Categories category, int rating, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {

    public Product(int id, String name, Categories category, int rating) {
        this(id, name, category, rating, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

    public Product {
        createdDate = createdDate.truncatedTo(ChronoUnit.SECONDS);
        lastModifiedDate = lastModifiedDate.truncatedTo(ChronoUnit.SECONDS);
    }

    public LocalDateTime createdDate() {
        return createdDate;
    }

    public LocalDateTime lastModifiedDate() {
        return lastModifiedDate;
    }
}