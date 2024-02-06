package com.example.bookingplatform.hotel.room.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCreateDto {
    @NotBlank
    private Integer roomCount ;

    @NotBlank
    private Integer number;

    @NotBlank
    private Long hotelId;
}
