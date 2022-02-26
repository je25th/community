package com.project.community.domain.service;

import com.project.community.domain.member.Member;
import com.project.community.domain.member.MemberService;
import org.junit.Assert;
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
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = Member.createMember("유저1", "userId@email.com", "password");

        //when
        Long saveId = memberService.join(member);

        //then
        Assert.assertEquals(member, memberService.findOne(saveId));
    }


    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() {
        //given
        Member member1 = Member.createMember("유저1", "userId@email.com", "password");
        Member member2 = Member.createMember("유저2", "userId@email.com", "password");

        //when
        memberService.join(member1);
        memberService.join(member2);

        //then
        fail("이메일 중복으로 예외가 발생해야함");
    }
}