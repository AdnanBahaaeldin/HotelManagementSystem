package com.adnan.hotelreservationsystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Room {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String roomType;
    private String status;
}