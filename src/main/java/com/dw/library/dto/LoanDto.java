package com.dw.library.dto;

import com.dw.library.model.Book;
import com.dw.library.model.Member;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoanDto {
    @NotBlank
    private long loanId;
    @NotBlank
    private MemberDto member;
    @NotBlank
    private BookDto book;
    @NotBlank
    @PastOrPresent(message = "반납일은 현재 또는 과거 날짜여야 합니다")
    private LocalDateTime loanDate;
    @NotBlank
    @Future(message = "반납예정일은 미래 날짜여야 합니다")
    private LocalDateTime dueDate;
    @NotBlank
    @PastOrPresent(message = "실제반납일은 현재 또는 과거 날짜여야 합니다")
    private LocalDateTime returnDate;


    private String status; // (ACTIVE/RETURNED/OVERDUE)
    @NotBlank
    @Min(value = 0, message = "연체료 0 이상이어야 합니다")
    private int fineAmount;
    @NotBlank
    @PastOrPresent(message = "생성일은 현재 또는 과거 날짜여야 합니다")
    private LocalDateTime createdAt;
}
