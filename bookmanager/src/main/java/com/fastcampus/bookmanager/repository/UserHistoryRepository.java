package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
