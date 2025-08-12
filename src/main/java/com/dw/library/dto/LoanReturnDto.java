package com.dw.library.dto;

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
    @NotBlank
    private String memberEmail;
    @NotBlank
    private long bookId;
    private LocalDateTime returnDate; //실제반납일
    private String status; // (ACTIVE/RETURNED/OVERDUE)
    private LocalDateTime createdAt;
}
