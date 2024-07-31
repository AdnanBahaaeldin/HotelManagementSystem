package com.adnan.hotelreservationsystem.Repository;
import com.adnan.hotelreservationsystem.Model.Room;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE room Set status = :status WHERE id = :id" , nativeQuery = true)
    void updateRoomStatus(String status, int id);

}
