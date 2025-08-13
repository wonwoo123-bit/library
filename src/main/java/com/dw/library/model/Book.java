package com.dw.library.model;

import com.dw.library.dto.BookByIdDto;
import com.dw.library.dto.BookDto;
import com.dw.library.dto.BooksAllDto;
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
    private int availableQuantity = totalQuantity;
    private String location;
    private LocalDateTime createdAt;

    public Book(String isbn, String title, String author, String publisher,
                int publicationYear, String category, int totalQuantity, String location) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = totalQuantity; // 자동 설정
        this.location = location;
        this.createdAt = LocalDateTime.now(); // 자동 설정
    }


    public BookDto toDto(){
        return new BookDto(
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
    public BooksAllDto booksAllDto(){
        return new BooksAllDto(
                this.bookId,
                this.isbn,
                this.title,
                this.author,
                this.publisher,
                this.category,
                this.totalQuantity,
                this.location,
                this.availableQuantity
        );
    }
    public BookByIdDto bookByIdDto(){
        return new BookByIdDto(
                this.bookId,
                this.isbn,
                this.title,
                this.author,
                this.publisher,
                this.publicationYear,
                this.category,
                this.totalQuantity,
                this.location,
                this.availableQuantity
        );
    }
}
