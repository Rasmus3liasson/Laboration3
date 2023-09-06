package org.laboration3.entities;

import java.time.LocalDate;

public record Product (int id, String name, String category, int rating, LocalDate createdDate, LocalDate lastModifiedDate) {

}
