package com.example.bookingplatform.hotel;

import com.example.bookingplatform.address.AddressRepository;
import com.example.bookingplatform.address.entity.Address;
import com.example.bookingplatform.address.entity.City;
import com.example.bookingplatform.hotel.dto.HotelCreateDto;
import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.dto.HotelUpdateDto;
import com.example.bookingplatform.hotel.entity.Hotel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {
     private final HotelRepository hotelRepository;
     private final AddressRepository addressRepository;
     private final ModelMapper modelMapper;


     public List<HotelResponseDto> get(){
         List<Hotel> all = hotelRepository.findAll();
      return all.stream().map(hotel -> modelMapper.map( hotel , HotelResponseDto.class))
              .collect(Collectors.toList());
     }

     public void create(HotelCreateDto createDto){

         Address address = new Address(null , City.valueOf(createDto.getCity()) , createDto.getName());

         addressRepository.save(address);

         Hotel hotel = new Hotel(null , createDto.getName(), address , new ArrayList<>());

         hotelRepository.save(hotel);
     }

    public HotelResponseDto getById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Hotel not found"));

        return modelMapper.map(hotel, HotelResponseDto.class);
    }


    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }

    public void update(Long id, HotelUpdateDto updateDto) {


        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Hotel not found"));


        Address address = hotel.getAddress();

        address.setStreet(updateDto.getStreet());
        address.setCity(City.valueOf(updateDto.getCity()));

        addressRepository.save(address) ;

        hotel.setAddress(address);
        hotel.setName(updateDto.getName());

        hotelRepository.save(hotel) ;
    }
}
