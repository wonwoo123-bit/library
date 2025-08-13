package com.dw.library.service;

import com.dw.library.dto.BookByIdDto;
import com.dw.library.dto.BookDto;
import com.dw.library.dto.BooksAllDto;
import com.dw.library.exception.ResourceNotFoundException;
import com.dw.library.mapper.BookMapper;
import com.dw.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
//    모든 책 조회 (검색)
    public List<BooksAllDto> getAllBooks(int page,
                                         int size,
                                         String keyword,
                                         String category) {
        int offset = page * size;
        return bookMapper.getAllBooks(offset,size,keyword,category)
                .stream()
                .map(Book::booksAllDto)
                .toList();
    }

    //    책 id로 조회
    public BookByIdDto getBookById(long id){
        Book book = bookMapper.getBookById(id);
        if (book != null) {
            return book.bookByIdDto();
        } else {
            throw new ResourceNotFoundException("해당 책이 없습니다. ID : " + id);
        }
    }

    // 도서 수정
    @Transactional
    public String updateBook(Long bookId, BookDto bookDto) {
        Book book = bookMapper.getBookById(bookId);
        if (book == null) {
            throw new ResourceNotFoundException("도서가 존재하지 않습니다.");
        }
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setPublicationYear(bookDto.getPublicationYear());
        book.setCategory(bookDto.getCategory());
        book.setTotalQuantity(bookDto.getTotalQuantity());
        book.setLocation(bookDto.getLocation());

        int updatedRows = bookMapper.updateBook(book);

        if (updatedRows > 0) {
            return "도서 " + bookId + "의 정보가 수정되었습니다.";
        } else {
            return "도서 " + bookId + "의 정보 수정에 실패하였습니다.";
        }
    }

    // 도서 삭제
    @Transactional
    public String deleteBook(Long bookId) {
        Book book = bookMapper.findByBookId(bookId);
        if (book == null) {
            throw new IllegalArgumentException("해당 도서를 찾을 수 없습니다.");
        }

        int deletedRows = bookMapper.deleteBook(bookId);
        if (deletedRows > 0) {
            return "도서" + bookId + "이(가) 정상적으로 삭제되었습니다.";
        } else {
            return "해당 도서 삭제에 실패하였습니다.";
        }
    }

}
