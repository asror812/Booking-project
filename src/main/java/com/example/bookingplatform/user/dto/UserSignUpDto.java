package com.example.bookingplatform.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSignUpDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
