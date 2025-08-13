package com.dw.library.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReservationRequestDto {
    private Long memberId; // member_id FK 회원ID
    private Long bookId; // book_id FK 도서ID
}
