package com.project.community.web.post;

import com.project.community.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostForm {
    private Member member;

    private String title;
    private String content;
}
