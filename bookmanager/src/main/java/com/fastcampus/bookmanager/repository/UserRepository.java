package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // query method
    List<User> findByName(String name);

    User findByEmail(String email);
    User getByEmail(String email);
    User readByEmail(String email);
    User queryByEmail(String email);
    User searchByEmail(String email);
    User streamByEmail(String email);

    User findSomethingByEmail(String email);

    User findFirst1ByName(String name);
    List<User> findTop2ByName(String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);
    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);
    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);
    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByNameIsNotNull();
    List<User> findByNameIsNull();

    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContaining(String name);

    List<User> findTop1ByNameOrderByIdDesc(String name);
    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);
}
