package com.example.bookingplatform.address.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Enumerated(value = EnumType.STRING)
    private City city;
    private String street;
}
