package com.example.bookingplatform.address;


import com.example.bookingplatform.hotel.HotelService;
import com.example.bookingplatform.hotel.dto.HotelCreateDto;
import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final HotelService hotelService;


}
