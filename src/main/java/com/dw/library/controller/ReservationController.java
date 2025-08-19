package com.dw.library.controller;


import com.dw.library.dto.ReservationRequestDto;
import com.dw.library.dto.ReservationResponseDto;
import com.dw.library.model.Reservation;
import com.dw.library.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping("/reservations")
    // 도서 예약
    public ResponseEntity<Long> saveReservation (
            @Valid @RequestBody ReservationRequestDto requestDto){
        return new ResponseEntity<>(reservationService.saveReservation(requestDto), HttpStatus.CREATED);
    }


    @GetMapping("/reservations/search")
    // 예약 목록 조회
    public ResponseEntity<List<ReservationResponseDto>> getAllReservations (
            @RequestParam(required = false) String memberEmail,
            @RequestParam(required = false) Long bookId) {
        return new ResponseEntity<>(reservationService.getAllReservation(memberEmail, bookId), HttpStatus.OK);
    }



    @DeleteMapping("/delete/{reservationId}")
    // 예약 도서 취소
    public ResponseEntity<String> deleteReservation (
            @PathVariable long reservationId) {
        return new ResponseEntity<>(reservationService.deleteReservation(reservationId),HttpStatus.OK);
    }
}
