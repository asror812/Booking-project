package com.example.bookingplatform.address;


import com.example.bookingplatform.hotel.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final HotelService hotelService;

}
