package com.example.bookingplatform.hotel.dto;

import com.example.bookingplatform.address.entity.Address;
import com.example.bookingplatform.address.entity.City;
import com.example.bookingplatform.hotel.room.entity.Room;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelCreateDto {

    @NotBlank
    private String name;
    @NotBlank
    private String street;

    @NotBlank
    private String city;


}
