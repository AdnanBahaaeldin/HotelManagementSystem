package com.adnan.hotelreservationsystem.Services;
import com.adnan.hotelreservationsystem.Dto.DtoReservation;
import com.adnan.hotelreservationsystem.DtoMapper.DtoReservationMapper;
import com.adnan.hotelreservationsystem.Model.Reservation;
import com.adnan.hotelreservationsystem.Repository.ReservationRepo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    ReservationRepo reservationRepo;

    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY")
    LocalDateTime currentDate = LocalDateTime.now();

    @Autowired
    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    public List<DtoReservation> getAllReservations() {
        List<Reservation> reservations = reservationRepo.findAll();
        List<DtoReservation> dtoReservations = new ArrayList<>();

        for (Reservation reservation : reservations) {
            dtoReservations.add(DtoReservationMapper.map(reservation));
        }
        return dtoReservations;
    }

    public void addReservation(Reservation reservation) {
        reservationRepo.save(reservation);
    }

    public void deleteReservation(int userId,int roomId) {
        reservationRepo.deleteReservationById(userId,roomId);
    }

    public void updateReservationCheckoutDate(LocalDateTime checkInDate, LocalDateTime checkOutDate , int userId , int roomId) {
        if (currentDate.compareTo(checkInDate) > 1 ) {
            checkInDate = currentDate;
        }
        reservationRepo.updateCheckoutDate(checkInDate, checkOutDate, userId, roomId);
    }
}
