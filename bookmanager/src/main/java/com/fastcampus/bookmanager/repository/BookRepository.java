package com.fastcampus.bookmanager.repository;

import com.fastcampus.bookmanager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
