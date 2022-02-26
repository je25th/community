package com.project.community.domain.service;

import com.project.community.domain.member.Member;
import com.project.community.domain.post.Post;
import com.project.community.domain.member.MemberService;
import com.project.community.domain.post.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    MemberService memberService;

    @Test
    public void 글쓰기() {
        //given
        Member member = Member.createMember("유저1", "email@domain.com", "password");
        memberService.join(member);

        //when
        String title = "제목";
        String content = "가나다라마바사 아자차카";
        Long postId = postService.write(member.getId(), title, content);

        //then
        Post post = postService.findOne(postId);
        Member writer = memberService.findOne(post.getMember().getId());

        assertEquals("작성자", member, writer);
        assertEquals("제목", title, post.getTitle());
        assertEquals("내용", content, post.getContent());
        assertNotNull("작성일시가 null이 아님", post.getCreateDate());
    }
}