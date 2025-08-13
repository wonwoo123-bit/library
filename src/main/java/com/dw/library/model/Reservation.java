package com.dw.library.model;

import com.dw.library.dto.ReservationRequestDto;
import com.dw.library.dto.ReservationResponseDto;
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
    private Member member; // email
    private Book book; // book_id FK 도서ID
    private LocalDateTime reservationDate; // reservation_date 예약일
    private LocalDateTime expiryDate; // expiry_date 예약만료일
    private LoanStatus status; // status 상태(ACTIVE/CANCELLED/FULFILLED)
    private Integer queuePosition; // queue_position 대기순번
    private LocalDateTime createdAt; // created_at 예약신청일시
    private LocalDateTime updatedAt; // updated_at 수정일시

    public ReservationRequestDto reservationRequestDto() {
        return new ReservationRequestDto(
                this.member.getEmail(),
                this.book.getBookId()
        );
    }

    public ReservationResponseDto reservationResponseDto() {
        return new ReservationResponseDto(
                this.reservationId,
                this.queuePosition,
                this.reservationDate,
                this.expiryDate
        );
    }
}
