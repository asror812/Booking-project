package com.example.bookingplatform.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor@NoArgsConstructor
@Data
public class HotelUpdateDto {


    private String name;
    private String city ;
    private String street ;
}
