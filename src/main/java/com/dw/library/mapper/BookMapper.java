package com.dw.library.mapper;

import com.dw.library.dto.BookDto;
import com.dw.library.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    void saveBook(@Param("BookDto")BookDto bookDto);

    List<Book> getAllBooks ();

    Book getBookById(@Param("id") long id);


}
