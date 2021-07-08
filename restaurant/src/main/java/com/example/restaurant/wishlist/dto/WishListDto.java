package com.example.restaurant.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class WishListDto { // WishListEntity 에 직접 접근하는 것은 데이터를 손상 시킬 수 있기 때문에 새로 만들어주었다.

    private Integer index;
    private String title;                   // 음식명, 장소명
    private String category;                // 카테고리
    private String address;                 // 주소
    private String roadAddress;             // 도로명
    private String homePageLink;            // 홈페이지 주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문여부
    private int visitCount;                 // 방문 카운트
    private LocalDateTime lastVisitDate;    // 마지막 방문일자
}
