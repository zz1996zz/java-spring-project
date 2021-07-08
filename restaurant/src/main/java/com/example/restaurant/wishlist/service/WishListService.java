package com.example.restaurant.wishlist.service;

import com.example.restaurant.naver.NaverClient;
import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;

    public WishListDto search(String query){

        // 지역검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        // 지역검색결과가 있을때
        if(searchLocalRes.getTotal() > 0) {
            var localItem = searchLocalRes.getItems().stream().findFirst().get(); // 검색된 것들 중 첫번째를 가져온다.
            // getTotal 에서 1이상이기 때문에 null 예외가 발생하지 않는다.

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", ""); // title 에 있는 이상한 문자들(괄호 등)을 모두 공백처리한다. 검색을 더 수월하게 해준다.

            // 지역검색 결과를 통한 이미지검색
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.searchImage(searchImageReq);

            if(searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                // 결과를 리턴
                var result = new WishListDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());

                return result;
            }
        }

        return new WishListDto();
    }

    public WishListDto add(WishListDto wishListDto) { // 위시리스트를 추가하는 메소드
        // 메모리 db에 저장해야한다. 메모리 db에 저장하기 위해서는 MemoryDbEntity 를 상속받은 클래스(WishListEntity)만 저장될 수 있기 때문에 아래 메소드(dtoToEntity, entityToDto)를 정의해준다.
        var entity = dtoToEntity(wishListDto);
        var saveEntity = wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDto wishListDto){
        var entity = new WishListEntity();

        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setVisit(wishListDto.isVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        entity.setLastVisitDate(wishListDto.getLastVisitDate());

        return entity;
    }

    private WishListDto entityToDto(WishListEntity wishListEntity){
        var dto = new WishListDto();

        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setRoadAddress(wishListEntity.getRoadAddress());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setVisit(wishListEntity.isVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());
        dto.setLastVisitDate(wishListEntity.getLastVisitDate());

        return dto;
    }

    public List<WishListDto> findAll() { // 위시리스트 전체를 출력하는 메소드
        return wishListRepository.findAll()
                .stream()
                .map(it -> entityToDto(it))
                .collect(Collectors.toList());
    }

    public void delete(int index) { // 인덱스에 해당하는 데이터를 삭제하는 메소드
        wishListRepository.deleteById(index);
    }

    public void addVisit(int index){ // 인덱스에 해당하는 데이터의 방문 횟수를 증가시키는 메소드
        var wishItem = wishListRepository.findById(index);
        if(wishItem.isPresent()){ // db 에 해당 index의 데이터가 있다면 데이터의 방문횟수를 늘린다.
            var item = wishItem.get();
            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
        }
    }
}
