package com.example.bookingplatform.hotel;


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
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    @GetMapping
    public String getAllHotels(Model model){
        List<HotelResponseDto> allHotels = hotelService.get();

      model.addAttribute("hotels" , allHotels);
      return "index" ;
    }
    @GetMapping("/create")
    public String getHotelCreatePage(){
        return "hotel/create" ;
    }

    @PostMapping
    public String createHotel(@Valid @ModelAttribute HotelCreateDto hotelCreateDto){

        hotelService.create(hotelCreateDto);
        return "index" ;
    }
}
