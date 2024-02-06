package com.example.bookingplatform.hotel;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HotelDtoMapper {
    private final ModelMapper mapper;


}
