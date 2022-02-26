package com.project.community.domain.login;

import com.project.community.domain.member.Member;
import com.project.community.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public LoginMember login(String email, String password) {
        Member member = memberRepository.findByEmail(email).filter(m -> m.getPassword().equals(password)).orElse(null);
        return new LoginMember(member.getId(), member.getNickname(), member.getAccountType(), member.getEmail());
    }

}
