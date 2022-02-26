package com.project.community.domain.login;

import com.project.community.domain.member.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginMember {
    private Long id;
    private String nickname;
    private AccountType accountType;
    private String email;
}
