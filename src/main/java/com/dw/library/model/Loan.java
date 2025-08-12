package com.dw.library.model;

import com.dw.library.dto.LoanDto;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Loan {
    private Long loanId; // 대출ID
    private Member member; //회원ID
    private Book book; // 도서ID
    private LocalDateTime loanDate; // 대출일
    private LocalDateTime dueDate; //반납예정일
    private LocalDateTime returnDate; //실제반납일
    private String status; // 상태(ACTIVE/RETURNED/OVERDUE)
    private int fineAmount; // 연체료
    private LocalDateTime createdAt; // 대출신청일시


    public LoanDto toDto() {
        return new LoanDto(
                this.loanId,
                this.member.getEmail(),
                this.book.getBookId(),
                this.loanDate,
                this.dueDate,
                this.status
        );
    }

}