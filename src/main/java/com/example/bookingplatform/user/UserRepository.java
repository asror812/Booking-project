package com.example.bookingplatform.user;

import com.example.bookingplatform.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User , UUID> {

    Optional<User> findUserByPhoneNumber(String phoneNumber);

}
