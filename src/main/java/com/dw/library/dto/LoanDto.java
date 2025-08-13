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
    private String memberEmail; //회원ID
    private long bookId; // 도서ID

}
