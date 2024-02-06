package com.example.bookingplatform.hotel.room.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDto {

    private Long id;
    private Integer roomCount ;
    private Integer number;
    private Long hotelId;
}
