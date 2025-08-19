package com.dw.library.mapper;

import com.dw.library.model.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReservationMapper {
    long saveReservation(@Param("reservation")Reservation reservationId);

    List<Reservation> getAllReservation (@Param("member") String memberEmail,
                                         @Param("book") Long bookId);

    Reservation findByReservationId(@Param("reservationId") Long reservationId);

    long deleteReservation(@Param("reservationId") Long reservationId);

}
