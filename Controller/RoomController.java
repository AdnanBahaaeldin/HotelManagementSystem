package com.adnan.hotelreservationsystem.Controller;
import com.adnan.hotelreservationsystem.Dto.DtoRoom;
import com.adnan.hotelreservationsystem.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotel/rooms")
public class RoomController {

    RoomService roomService ;

    @Autowired
    public RoomController (RoomService service) {
        this.roomService = service;
    }

    @GetMapping("/getAll")
    public List<DtoRoom> getRooms() {
       return roomService.getRooms();
    }

    @GetMapping("/getAvailable")
    public ResponseEntity<List<DtoRoom>> getAvailableRooms() {
        return new ResponseEntity<>(roomService.getAvailableRooms(), HttpStatus.OK);
    }

    @GetMapping("/get/{filter}")
    public ResponseEntity<List<DtoRoom>> getFilteredRooms(@PathVariable String filter) {
        return new ResponseEntity<>(roomService.getFilteredRooms(filter),HttpStatus.OK);
    }

}
