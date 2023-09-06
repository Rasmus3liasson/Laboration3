package org.laboration3.entities;


import java.time.LocalDateTime;

public record Product (int id, String name, Categories category, int rating, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {

}
