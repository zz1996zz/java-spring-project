package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// naver 서버와 연동하여 Request에 저장된 query 값에 해당하는 정보들을 가져오는 클래스
@Component
public class NaverClient {

    @Value("${naver.client.id}") // yaml 파일에서 해당 값을 가져온다.
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq){

        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)// uri 를 만들어준다.
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        // request header 부분을 세팅해준다.
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){}; // responseType 을 지정해준다.

        var responseEntity = new RestTemplate().exchange( // 서버에 요청해준다.
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody(); // 요청한 값을 가져온다.
    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq){

        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );

        return responseEntity.getBody();
    }
}
