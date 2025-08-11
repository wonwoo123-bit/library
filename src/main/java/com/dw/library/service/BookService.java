package com.dw.library.service;

import com.dw.library.dto.BookDto;
import com.dw.library.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public BookDto saveBook(BookDto bookDto){
        bookMapper.saveBook(bookDto);
        return bookDto;
    }
}
