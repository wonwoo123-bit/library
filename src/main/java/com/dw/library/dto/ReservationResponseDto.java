package com.dw.library.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReservationResponseDto {
    private Long reservationId; // reservation_id 예약ID
    private Integer queuePosition; // queue_position 대기순번
    private LocalDateTime reservationDate; // reservation_date 예약일
    private LocalDateTime expiryDate; // expiry_date 예약만료일

}
