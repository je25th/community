package com.project.community.domain.service;

import com.project.community.domain.login.LoginMember;
import com.project.community.domain.login.LoginService;
import com.project.community.domain.member.Member;
import com.project.community.domain.member.MemberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class LoginServiceTest {

    @Autowired
    LoginService loginService;
    @Autowired
    MemberService memberService;

    @Test
    public void 로그인_성공() {
        String email = "email@mail.com";
        String password = "pass";
        Long id = memberService.join(Member.createMember("user", email, password));

        LoginMember login = loginService.login(email, password);

        Assert.assertEquals(id, login.getId());
        Assert.assertEquals(email, login.getEmail());
    }

    @Test
    public void 비밀번호_틀려서_로그인_실패() {
        String email = "email@mail.com";
        String password = "pass";
        Long id = memberService.join(Member.createMember("user", email, password));

        LoginMember login = loginService.login(email, "test");

        Assert.assertNull(login);
    }

    @Test
    public void 이메일_틀려서_로그인_실패() {
        String email = "email@mail.com";
        String password = "pass";
        Long id = memberService.join(Member.createMember("user", email, password));

        LoginMember login = loginService.login("test@email.com", password);

        Assert.assertNull(login);
    }
}
