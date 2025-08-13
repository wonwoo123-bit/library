package com.dw.library.mapper;

import com.dw.library.dto.BookDto;
import com.dw.library.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    int saveBook(@Param("Book")Book book);

    List<Book> getAllBooks (@Param("offset") int offset,
                            @Param("limit") int limit,
                            @Param("keyword")String keyword,
                            @Param("category")String category);

    Book getBookById(@Param("book") long id);

    int updateBook(@Param("book")Book book);


    Book findByBookId(@Param("bookId") Long bookId);
    int deleteBook(@Param("bookId") Long bookId);


}
