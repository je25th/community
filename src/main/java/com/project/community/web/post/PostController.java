package com.project.community.web.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model) {

        return "post/posts";
    }

    //TODO:포스팅 등록화면

    //TODO:포스팅 등록

    //TODO:포스팅 상세

    //TODO:포스팅 수정화면

    //TODO:포스팅 수정

    //TODO:포스팅 좋아요 토글

    //TODO:회원의 좋아요 목록

    //TODO:회원의 작성 포스팅 목록
}
