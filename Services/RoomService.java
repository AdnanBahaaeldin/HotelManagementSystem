package com.adnan.hotelreservationsystem.Services;
import com.adnan.hotelreservationsystem.Dto.DtoRoom;
import com.adnan.hotelreservationsystem.DtoMapper.DtoRoomMapper;
import com.adnan.hotelreservationsystem.Model.Room;
import com.adnan.hotelreservationsystem.Repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    RoomRepo roomRepo;

    @Autowired
    public RoomService (RoomRepo repo) {
        this.roomRepo = repo;
    }

    public List<DtoRoom> getRooms() {
        List<Room> rooms =  roomRepo.findAll();
        List<DtoRoom> dtoRooms = new ArrayList<>();
        for (Room room : rooms) {
            dtoRooms.add(DtoRoomMapper.map(room));
        }
        return dtoRooms;
    }

    public List<DtoRoom> getAvailableRooms() {
        List<Room> rooms =  roomRepo.findAll();
        List<DtoRoom> dtoRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getStatus().equals("Available")) {
                dtoRooms.add(DtoRoomMapper.map(room));
            }
        }
        return dtoRooms;
    }

    public List<DtoRoom> getFilteredRooms(String filter) {
        List<Room> rooms =  roomRepo.findAll();
        List<DtoRoom> dtoRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equals(filter)){
                dtoRooms.add(DtoRoomMapper.map(room));
            }
        }
        return dtoRooms;
    }

    public void updateRoomStatus(int roomId, String status) {
        roomRepo.updateRoomStatus(status, roomId);
    }
}
