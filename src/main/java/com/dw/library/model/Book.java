package com.dw.library.model;

import com.dw.library.dto.BookDto;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Book {
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
    private LocalDateTime createdAt;

    public BookDto toDto(){
        return new BookDto(
                this.bookId,
                this.isbn,
                this.title,
                this.author,
                this.publisher,
                this.publicationYear,
                this.category,
                this.totalQuantity,
                this.location
        );
    }
}
