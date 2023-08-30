package mvcPattern.sadstill.webLibrary.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;

    private String name;

    private String author;

    private int birthDate;
}
