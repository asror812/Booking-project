package com.example.bookingplatform.hotel.room.entity;

import com.example.bookingplatform.hotel.entity.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Integer number;
    private Integer roomCount;
    @ManyToOne
    private Hotel hotel;
}
