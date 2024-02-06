package com.example.bookingplatform.user;

import com.example.bookingplatform.user.dto.UserResponseDto;
import com.example.bookingplatform.user.dto.UserSignInDto;
import com.example.bookingplatform.user.dto.UserSignUpDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import  com.example.bookingplatform.user.entity.User ;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(UserSignInDto registerDto) {

        User entity = new User(null , registerDto.getFirstname(), registerDto.getSurname(),  registerDto.getPhoneNumber(),
                                      registerDto.getPassword() ,registerDto.getUsername()) ;


        String encode = passwordEncoder.encode(registerDto.getPassword());


        entity.setPassword(encode);

        repository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByPhoneNumber(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }


    @Transactional
    public void signUp(UserSignUpDto dto) {
        User user = repository.findUserByPhoneNumber(dto.getUsername()).orElseThrow(
                () -> new BadCredentialsException("Phone number or password is incorrect"));


        if(!passwordEncoder.matches(user.getPassword(), dto.getPassword())){
            throw new BadCredentialsException("Phone number or password is incorrect");
        }

    }

}
