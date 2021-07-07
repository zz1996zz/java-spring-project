package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    Optional<T> findById(int index); // 인덱스에 해당하는 entity를 찾아주는 메소드
    T save(T entity); // entity 저장하는 메소드
    void deleteById(int index); // index에 해당하는 entity를 삭제해주는 메소드
    List<T> listAll(); // db 전체를 반환해주는 메소드
}
