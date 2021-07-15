package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        userRepository.save(new User());
        userRepository.save(new User());

        System.out.println(">>> " + userRepository.findAll());
    }
}