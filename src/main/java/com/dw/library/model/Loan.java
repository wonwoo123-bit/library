package com.dw.library.model;

import com.dw.library.dto.LoanDto;
import com.dw.library.dto.LoanGetDto;
import com.dw.library.dto.LoanOverdueDto;
import com.dw.library.dto.LoanReturnDto;
import com.dw.library.enums.LoanStatus;
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
    private LoanStatus status; // 상태(ACTIVE/RETURNED/OVERDUE)
    private Integer fineAmount; // 연체료
    private LocalDateTime createdAt; // 수정일시


    public LoanDto toDto() {
        return new LoanDto(
                this.member.getEmail(),
                this.book.getBookId()
        );
    }
    public LoanGetDto loanGetDto(){
        return new LoanGetDto(
                this.loanId,
                this.member.getName(),
                this.book.getTitle(),
                this.getLoanDate(),
                this.getDueDate(),
                this.status
        );
    }

    public LoanReturnDto loanReturnDto(){
        return new LoanReturnDto(
                this.loanId,
                this.book.getBookId()
        );
    }

    public LoanOverdueDto loanOverdueDto(){
        return new LoanOverdueDto(
                this.loanId,
                this.member.getName(),
                this.book.getTitle(),
                this.getLoanDate(),
                this.getDueDate(),
                this.status
        );
    }
}