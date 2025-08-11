package com.dw.library.controller;

import com.dw.library.dto.BookDto;
import com.dw.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
//    책 저장
    public ResponseEntity<BookDto> saveBook (@RequestBody BookDto bookDto){
        return null;
    }

    @GetMapping
//    모든 책 조회
    public ResponseEntity<List<BookDto>> getAllBooks (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return null;
    }

    @GetMapping("/books/{bookId}")
//    책 id로 조회
    public ResponseEntity<BookDto> getBookById (@PathVariable long id){
        return null;
    }

}
