package com.dw.library.dto;

import com.dw.library.model.Book;
import com.dw.library.model.Member;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReservationRequestDto {
    private String memberEmail; //회원ID
    private long bookId;
}
