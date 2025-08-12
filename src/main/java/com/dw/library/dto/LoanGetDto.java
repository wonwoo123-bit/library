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
public class LoanGetDto {
    private Long loanId; // 대출 ID
    private String memberName; //회원 이름
    private String bookTitle; // 도서명
    private LocalDateTime loanDate; // 대출일
    private LocalDateTime dueDate; //반납예정일
    private String status; // 상태(ACTIVE/RETURNED/OVERDUE)
}
