package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    @GetMapping("/main")
    public ModelAndView main(){ // 타임리프에서 모델을 뷰로 보낼때 사용한다.
        return new ModelAndView("abc/main"); // pages/main 에 접근하면 resources templates 에 있는 파일명이 main 인 html 파일을 리턴시킨다는 의미이다.
    }
}
