package com.dw.library.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Loan {
    private long loanId;
    private Member memberId;
    private Book bookId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private String status;
    private int fineAmount;
    private LocalDateTime createdAt;


}
