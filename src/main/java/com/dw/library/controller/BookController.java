package com.dw.library.controller;

import com.dw.library.dto.BookDto;
import com.dw.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> saveBook (@RequestBody BookDto bookDto){
        return null;
    }

    @GetMapping
    public ResponseEntity<BookDto> getAllBooks (){
        return null;
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDto> getBookById (@PathVariable long id){
        return null;
    }

}
