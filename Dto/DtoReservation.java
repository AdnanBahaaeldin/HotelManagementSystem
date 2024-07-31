package com.adnan.hotelreservationsystem.Dto;
import com.adnan.hotelreservationsystem.Model.Room;
import com.adnan.hotelreservationsystem.Model.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;

public record DtoReservation(
        User user,
        Room room,
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime checkInDate,
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        LocalDateTime checkOutDate,
        String status) {
}
