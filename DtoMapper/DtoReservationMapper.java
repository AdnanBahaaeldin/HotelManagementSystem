package com.adnan.hotelreservationsystem.DtoMapper;

import com.adnan.hotelreservationsystem.Dto.DtoReservation;
import com.adnan.hotelreservationsystem.Model.Reservation;

public class DtoReservationMapper {

    public static DtoReservation map (Reservation reservation) {
        return new DtoReservation(
                reservation.getUser(),
                reservation.getRoom(),
                reservation.getCheckInDate(),
                reservation.getCheckOutDate(),
                reservation.getStatus());
    }
}
