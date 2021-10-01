package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Gender;
import com.fastcampus.bookmanager.domain.User;
import com.fastcampus.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    void crud(){

//        userRepository.findAll().forEach(System.out::println);

//        User user1 = new User("jack", "jack@gmail.com");
//        User user2 = new User("steve", "steve@gmail.com");

//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//        List<User> users = userRepository.findAll();

//        users.forEach(System.out::println);
    }

    @Test
    void select(){

//        System.out.println(userRepository.findByName("martin"));

//        System.out.println(userRepository.findByEmail("dennis@fastcampus.com"));
//        System.out.println(userRepository.getByEmail("dennis@fastcampus.com"));
//        System.out.println(userRepository.readByEmail("dennis@fastcampus.com"));
//        System.out.println(userRepository.queryByEmail("dennis@fastcampus.com"));
//        System.out.println(userRepository.searchByEmail("dennis@fastcampus.com"));
//        System.out.println(userRepository.streamByEmail("dennis@fastcampus.com"));

//        System.out.println(userRepository.findSomethingByEmail("dennis@fastcampus.com"));

//        System.out.println(userRepository.findFirst1ByName("martin"));
//        System.out.println(userRepository.findTop2ByName("martin"));

//        System.out.println(userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println(userRepository.findByIdAfter(4L));

//        System.out.println(userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println(userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println(userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

//        System.out.println(userRepository.findByNameIsNotNull());
//        System.out.println(userRepository.findByNameIsNull());

//        System.out.println(userRepository.findByNameStartingWith("mar"));
//        System.out.println(userRepository.findByNameEndingWith("tin"));
//        System.out.println(userRepository.findByNameContaining("rt"));
    }

    @Test
    void pagingAndSortingTest(){

//        System.out.println(userRepository.findTop1ByNameOrderByIdDesc("martin"));
//        System.out.println(userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));

//        System.out.println(userRepository.findFirstByName("martin",
//                Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
//        System.out.println(userRepository.findFirstByName("martin", getSort()));

//        System.out.println(userRepository.findByName("martin", PageRequest.of(0, 2, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    private Sort getSort(){
        return Sort.by(Sort.Order.desc("id"),
                Sort.Order.asc("email"),
                Sort.Order.desc("createdAt"),
                Sort.Order.asc("updatedAt"));
    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrrtin");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));
    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("david");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MALE);

        userRepository.save(user);

//        userHistoryRepository.findAll().forEach(System.out::println);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@fastcampus.com");
        userRepository.save(user);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@fastcampus.com").getId());

//        result.forEach(System.out::println);

        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com").getUserHistories();
        result.forEach(System.out::println);
    }
}