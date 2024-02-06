package com.example.bookingplatform.user.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSignInDto {


    @NotBlank
    private String firstname;

    @NotBlank
    private String surname;

    @Pattern(regexp = "^\\+998[0-9]{9}$" ,  message = "Invalid phone number ")
    private String phoneNumber;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private UUID id;
/*
    @NotBlank
    private String firstname;

    @NotBlank
    private String surname;

    @Pattern(regexp = "^+998[0-9]{9}$")
    private String phoneNumber;

    private String password;

    private String username;*/

}
