package com.dw.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookDto {
    private long bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private String category;
    private int totalQuantity;
    private int availableQuantity;
    private String location;
}
