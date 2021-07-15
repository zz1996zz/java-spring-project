package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
