package com.adnan.hotelreservationsystem.Repository;
import com.adnan.hotelreservationsystem.Model.Reservation;
import com.adnan.hotelreservationsystem.Model.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
@Component
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservation WHERE user_id = :userId AND room_id = :roomId" , nativeQuery = true)
    void deleteReservationById(int userId,int roomId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservation SET check_in_date = :checkInDate, check_out_date = :checkOutDate WHERE user_Id = :userId AND room_Id = :roomId ", nativeQuery = true)
    void updateCheckoutDate(LocalDateTime checkInDate, LocalDateTime checkOutDate, int userId, int roomId);

}
