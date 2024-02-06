package com.example.bookingplatform.hotel.room;


import com.example.bookingplatform.hotel.HotelService;
import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.room.dto.RoomCreateDto;
import com.example.bookingplatform.hotel.room.dto.RoomResponseDto;
import com.example.bookingplatform.hotel.room.dto.RoomUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;
    private final HotelService hotelService;


    @PostMapping
    public String createRoom(@ModelAttribute RoomCreateDto roomCreateDto , Model model){

        roomService.createRoom(roomCreateDto);

        List<RoomResponseDto> roomDtos = roomService.getHotelRooms(roomCreateDto.getHotelId());
        model.addAttribute("room" , roomDtos);

        return "redirect:/%d/rooms".formatted(roomCreateDto.getHotelId()) ;
    }

    @GetMapping("/{id}")
    public String get(@PathVariable Long id ,  Model model){
        HotelResponseDto hotel = hotelService.getById(id) ;
        model.addAttribute("hotel" , hotel);
        return "hotel/update" ;
    }

    @GetMapping("/{id}/edit")
    public String getRoomEditPage(@PathVariable Long id  , Model model){

        RoomResponseDto byId = roomService.getById(id);
        model.addAttribute("room" , byId);

        return "hotel/room-edit" ;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        RoomResponseDto roomResponseDto = roomService.getById(id);

        System.out.println(roomResponseDto.getHotelId());
        roomService.delete(id);


        return "redirect:/%d/rooms".formatted(roomResponseDto.getHotelId()) ;
    }


    @PutMapping("/{id}")
    public String editHotel(@PathVariable Long id ,
                            @ModelAttribute @Valid RoomUpdateDto updateDto){

        roomService.update(id , updateDto);

        Long hotelId = roomService.getById(id).getHotelId();
        return "redirect:/%d/rooms".formatted(hotelId) ;
    }
}
