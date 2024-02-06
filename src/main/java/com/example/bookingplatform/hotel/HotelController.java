package com.example.bookingplatform.hotel;


import com.example.bookingplatform.hotel.dto.HotelCreateDto;
import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.dto.HotelUpdateDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @GetMapping("/{id}/rooms")
    public String getHotelRoomsPage(@PathVariable Long id , Model model){
        HotelResponseDto hotelDto = hotelService.getById(id);

        model.addAttribute("hotel" , hotelDto );
        return "hotel/update" ;
    }




    @PutMapping("/{id}")
    public String editHotel(@PathVariable Long id ,
                                   @ModelAttribute @Valid HotelUpdateDto updateDto){

       hotelService.update(id , updateDto);

        return "redirect:/%d/rooms".formatted(id) ;
    }

    @PostMapping("/hotel-create")
    public String createHotel(@Valid @ModelAttribute HotelCreateDto hotelCreateDto){
        hotelService.create(hotelCreateDto);

        return "redirect:/" ;
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable  Long id ){
        hotelService.delete(id);
        return "redirect:/" ;
    }

}
