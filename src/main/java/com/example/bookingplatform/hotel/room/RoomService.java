package com.example.bookingplatform.hotel.room;

import com.example.bookingplatform.hotel.HotelRepository;
import com.example.bookingplatform.hotel.entity.Hotel;
import com.example.bookingplatform.hotel.room.dto.RoomCreateDto;
import com.example.bookingplatform.hotel.room.dto.RoomResponseDto;
import com.example.bookingplatform.hotel.room.dto.RoomUpdateDto;
import com.example.bookingplatform.hotel.room.entity.Room;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repository;
    private final HotelRepository hotelRepository;
    private final ModelMapper mapper;

    public void createRoom(RoomCreateDto roomCreateDto) {

        Room entity = mapper.map(roomCreateDto, Room.class);
        Hotel hotel = hotelRepository.findById(roomCreateDto.getHotelId()).orElseThrow(
                () -> new EntityNotFoundException("Hotel not found"));

        entity.setHotel(hotel);
        repository.save(entity);
    }

    public List<RoomResponseDto> getHotelRooms(Long id) {

        List<Room> rooms = repository.findAllByHotelId(id);

        return rooms.stream().map(
                room -> mapper.map(room, RoomResponseDto.class))
                    .collect(Collectors.toList());

    }

    public RoomResponseDto getById(Long id) {

        Room entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Room not found"));

        RoomResponseDto map = mapper.map(entity, RoomResponseDto.class);

        map.setHotelId(entity.getHotel().getId());
        return  map ;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, RoomUpdateDto updateDto) {


        Room room = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Room not found"));

        room.setRoomCount(updateDto.getRoomCount());
        room.setNumber(updateDto.getNumber());

        repository.save(room) ;
    }
}
