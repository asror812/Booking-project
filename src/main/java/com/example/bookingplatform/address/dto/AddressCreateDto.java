package com.example.bookingplatform.address.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressCreateDto {

    @NotBlank
    private String city;
    @NotBlank
    private String street;
}
