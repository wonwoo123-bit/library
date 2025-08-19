package com.dw.library.service;


import com.dw.library.dto.ReservationRequestDto;
import com.dw.library.dto.ReservationResponseDto;
import com.dw.library.exception.InvalidRequestException;
import com.dw.library.exception.ResourceNotFoundException;
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
    public List<ReservationResponseDto> getAllReservation(String email, Long bookId) {
        memberMapper.getMemberByEmail(email);
        if (email == null){
            throw new ResourceNotFoundException("해당 유저가 존재하지 않습니다.");
        }
        bookMapper.getBookById(bookId);
        if (bookId == null){
            throw new ResourceNotFoundException("해당 책 정보가 없습니다.");
        }

        return reservationMapper.getAllReservation(email, bookId).stream().map(Reservation::reservationResponseDto).toList();
    }


    // 예약 도서 취소
    public String deleteReservation (Long reservationId){
        Reservation reservation = reservationMapper.findByReservationId(reservationId);
        if (reservation == null){
            throw new InvalidRequestException("해당 예약건을 찾을 수 없음");
        }
        long deletedRows = reservationMapper.deleteReservation(reservationId);
        if (deletedRows > 0) {
            return "예약이 취소되었습니다";
        }else {
            return "해당 예약 취소가 실패되었습니다.";
        }
    }
}
