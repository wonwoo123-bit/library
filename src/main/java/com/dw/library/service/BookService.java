package com.dw.library.service;

import com.dw.library.dto.BookDto;
import com.dw.library.mapper.BookMapper;
import com.dw.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public long saveBook(BookDto bookDto){
        Book newBook = new Book(
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublisher(),
                bookDto.getPublicationYear(),
                bookDto.getCategory(),
                bookDto.getTotalQuantity(),
                bookDto.getLocation()
        );
        return bookMapper.saveBook(newBook);
    }
}
