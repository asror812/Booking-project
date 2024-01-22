package com.example.bookingplatform.hotel.dto;

import com.example.bookingplatform.address.entity.Address;
import com.example.bookingplatform.hotel.room.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponseDto {
    private Integer id;
    private String name;
    private Address address;
    private List<Room> rooms;
}
