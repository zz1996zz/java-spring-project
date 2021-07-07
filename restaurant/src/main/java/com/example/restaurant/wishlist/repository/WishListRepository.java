package com.example.restaurant.wishlist.repository;

import com.example.restaurant.db.MemoryDbRepositoryAbstract;
import com.example.restaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository // 데이터베이스를 저장하는 곳을 알리는 어노테이션
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
