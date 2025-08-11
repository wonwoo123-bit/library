package com.dw.library.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Loan {
    private long loanId;
    private memberId;
    bookId;
    loanDate;
    dueDate;
    returnDate;
    status;
    fineAmount;
    createdAt;
}
