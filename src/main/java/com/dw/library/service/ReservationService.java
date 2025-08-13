package com.dw.library.service;


import com.dw.library.dto.ReservationRequestDto;
import com.dw.library.dto.ReservationResponseDto;
import com.dw.library.mapper.BookMapper;
import com.dw.library.mapper.MemberMapper;
import com.dw.library.mapper.ReservationMapper;
import com.dw.library.model.Book;
import com.dw.library.model.Member;
import com.dw.library.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    BookMapper bookMapper;

    // 도서 예약
    public long saveReservation(ReservationRequestDto reservationRequestDto){

        Member member = memberMapper.getMemberByEmail(reservationRequestDto.getMemberEmail());
        Book book = bookMapper.findByBookId(reservationRequestDto.getBookId());

        Reservation newReservation = new Reservation();
            newReservation.setMember(member);
            newReservation.setBook(book);
            newReservation.setReservationDate(LocalDateTime.now());
        return reservationMapper.saveReservation(newReservation);
    }



    // 예약 목록 조회
    public ReservationResponseDto getAllReservation(String email) {
        Reservation reservation = ReservationMapper.getAllReservation(email);
        if (reservation != null) {
            return reservation.reservationResponseDto();
        } else {
            throw new RuntimeException("예약이 존재하지 않습니다");
        }
    }


    // 예약 도서 취소
    public String deleteReservation (Long reservationId){
        Reservation reservation = ReservationMapper.findByReservationId(reservationId);
        int deletedRows = ReservationMapper.deleteReservation(ReservationId);
        if (deletedRows > 0) {
            return "예약이 취소되었습니다";
        }
    }
}
