package com.dw.library.mapper;

import com.dw.library.model.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {
    int saveReservation(@Param("reservation")Reservation reservationId);

    List<Reservation> getAllReservation (@Param("memberEmail") String memberEmail,
                                         @Param("bookId") Long bookId);

    Reservation findByReservationId(@Param("reservationId") Long reservationId);

    int deleteReservation(@Param("reservationId") Long reservationId);

}
