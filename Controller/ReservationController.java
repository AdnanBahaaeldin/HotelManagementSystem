package com.adnan.hotelreservationsystem.Controller;
import com.adnan.hotelreservationsystem.Dto.DtoReservation;
import com.adnan.hotelreservationsystem.Dto.DtoUser;
import com.adnan.hotelreservationsystem.Model.Reservation;
import com.adnan.hotelreservationsystem.Model.User;
import com.adnan.hotelreservationsystem.Services.ReservationService;
import com.adnan.hotelreservationsystem.Services.RoomService;
import com.adnan.hotelreservationsystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel/reservations")
public class ReservationController {
    ReservationService reservationService;
    RoomService roomService;
    UserService userService;

    @Autowired
    public ReservationController(ReservationService reservationService , RoomService roomService,UserService userService) {
        this.reservationService = reservationService;
        this.roomService = roomService;
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<DtoReservation> getReservations() {
       return reservationService.getAllReservations();
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation (@RequestBody Reservation reservation) {

        Optional<DtoUser> user = userService.
                getAllUsers().
                stream().
                filter(u -> u.id() == reservation.getUser().getId()).
                filter(u -> u.name().equals(reservation.getUser().getName())).
                findFirst();

        if (user.isPresent()) {
            roomService.getAvailableRooms().
                        stream().
                        filter(r -> r.roomId() == reservation.getRoom().getId()).
                        findFirst().
                        ifPresent(r -> {reservationService.addReservation(reservation);
                        roomService.updateRoomStatus(reservation.getRoom().getId(),"Not Available");});
        }
        return ResponseEntity.ok().body(reservation);
    }

    @DeleteMapping("/delete/{userId}/{roomId}")
    public ResponseEntity<HttpStatus> deleteReservationById (@PathVariable int userId , @PathVariable int roomId) {
        reservationService.deleteReservation(userId,roomId);
        roomService.updateRoomStatus(roomId,"Available");
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping ("/update")
    public ResponseEntity<?> updateReservation (@RequestBody DtoReservation dtoReservation) {
        reservationService.updateReservationCheckoutDate(
                dtoReservation.checkInDate(),
                dtoReservation.checkOutDate(),
                dtoReservation.user().getId(),
                dtoReservation.room().getId());

        return ResponseEntity.ok().body(HttpStatus.OK);
    }

}
