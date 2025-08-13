package com.dw.library.model;

import com.dw.library.enums.LoanStatus;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Reservation {
    private Long reservationId; // reservation_id 예약ID
    private Long memberId; // member_id FK 회원ID
    private Long bookId; // book_id FK 도서ID
    private LocalDateTime reservationDate; // reservation_date 예약일
    private LocalDateTime expiryDate; // expiry_date 예약만료일
    private LoanStatus status; // status 상태(ACTIVE/CANCELLED/FULFILLED)
    private Integer queuePosition; // queue_position 대기순번
    private LocalDateTime createdAt; // created_at 예약신청일시
    private LocalDateTime updatedAt; // updated_at 수정일시
}
