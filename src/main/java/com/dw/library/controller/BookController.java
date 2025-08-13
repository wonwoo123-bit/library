package com.dw.library.controller;

import com.dw.library.dto.BookDto;
import com.dw.library.dto.BooksAllDto;
import com.dw.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/save")
//    책 저장
    public ResponseEntity<Long> saveBook (@RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.saveBook(bookDto), HttpStatus.CREATED);
    }

    @GetMapping
//    모든 책 조회
    public ResponseEntity<List<BooksAllDto>> getAllBooks (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category) {
        return new ResponseEntity<>(bookService.getAllBooks(
                page,size,keyword,category), HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}")
//    책 id로 조회
    public ResponseEntity<BookDto> getBookById (@PathVariable long id){
        return null;
    }

    // 도서 정보 수정
    @PutMapping("/update/{bookId}")
    public ResponseEntity<String> updateBook(
            @PathVariable Long bookId,
            @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.updateBook(bookId, bookDto), HttpStatus.OK);
    }

    // 도서 삭제
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook (@PathVariable Long bookId){
        return new ResponseEntity<>(bookService.deleteBook(bookId), HttpStatus.OK);

    }

}
