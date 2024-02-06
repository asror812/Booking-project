package com.example.bookingplatform.address.entity;


import com.example.bookingplatform.address.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final ModelMapper mapper;
    private final AddressRepository addressRepository;

    public void create(AddressCreateDto createDto){
        Address entity = mapper.map(createDto, Address.class);

        addressRepository.save(entity);
    }


    public void update(UUID id , AddressCreateDto createDto){

        Address address = addressRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Address not found"));


        address.setCity(City.valueOf(createDto.getCity()));
        address.setStreet(createDto.getStreet());

        addressRepository.save(address) ;
    }
}
