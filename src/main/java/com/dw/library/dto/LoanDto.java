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
    private String member;
    @NotBlank
    private long book;
    @PastOrPresent(message = "반납일은 현재 또는 과거 날짜여야 합니다")
    private LocalDateTime loanDate;
    @Future(message = "반납예정일은 미래 날짜여야 합니다")
    private LocalDateTime dueDate;
    private String status; // (ACTIVE/RETURNED/OVERDUE)
}
