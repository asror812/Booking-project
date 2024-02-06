package com.example.bookingplatform.hotel.dto;

import com.example.bookingplatform.address.entity.Address;
import com.example.bookingplatform.hotel.room.dto.RoomResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponseDto {
    private Long id;
    private String name;
    private Address address;
    private List<RoomResponseDto> rooms;
}
