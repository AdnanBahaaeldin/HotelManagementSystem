package com.adnan.hotelreservationsystem.DtoMapper;

import com.adnan.hotelreservationsystem.Dto.DtoRoom;
import com.adnan.hotelreservationsystem.Model.Room;

public class DtoRoomMapper {

    public static DtoRoom map (Room room) {
        return new DtoRoom(room.getId(), room.getRoomType(), room.getStatus());
    }
}
