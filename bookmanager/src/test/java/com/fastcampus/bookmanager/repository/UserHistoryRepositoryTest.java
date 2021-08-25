package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserHistoryRepositoryTest {

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void userHistoryTest(){
        User user = new User();
        user.setName("martin-new");
        user.setEmail("martin-new@fastcampus.com");

        userRepository.save(user);

        user.setName("martine-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }
}
