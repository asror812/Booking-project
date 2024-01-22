package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
