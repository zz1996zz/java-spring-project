package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
//        userRepository.findAll().forEach(System.out::println);

        User user1 = new User("jack", "jack@gmail.com");
        User user2 = new User("steve", "steve@gmail.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));
        List<User> users = userRepository.findAll();

        users.forEach(System.out::println);
    }
}