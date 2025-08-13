package com.dw.library.dto;

import com.dw.library.enums.LoanStatus;
import com.dw.library.model.Loan;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoanReturnDto {
    private Long id;
    @NotBlank
    private String memberEmail;
    @NotBlank
    private long bookId;
    private LoanStatus status; // (ACTIVE/RETURNED/OVERDUE)
}
