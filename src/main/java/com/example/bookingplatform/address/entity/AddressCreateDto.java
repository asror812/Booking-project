package com.example.bookingplatform.address.entity;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor
@Data
public class AddressCreateDto {

    @NotBlank
    private String city;

    @NotBlank
    private String street;
}
