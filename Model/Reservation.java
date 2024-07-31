package com.adnan.hotelreservationsystem.Model;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "room_id" , nullable = false)
    private Room room;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime checkInDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime checkOutDate;

    private String status;
}