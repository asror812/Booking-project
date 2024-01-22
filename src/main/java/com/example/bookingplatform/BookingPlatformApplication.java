package com.example.bookingplatform;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookingPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingPlatformApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

         modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
         return modelMapper;
    }

}
