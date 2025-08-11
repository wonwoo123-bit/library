package com.dw.library.dto;

import com.dw.library.model.Book;
import com.dw.library.model.Member;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoanDto {
    private long loanId;
    private MemberDto member;
    private BookDto book;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private String status;
    private int fineAmount;
    private LocalDateTime createdAt;
}
