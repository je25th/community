package com.project.community.domain.member;

import com.project.community.domain.BaseEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Member extends BaseEntity {

    protected Member(String nickname, AccountType accountType, String email, String password, Boolean quit, LocalDateTime createDate) {
        this.nickname = nickname;
        this.accountType = accountType;
        this.email = email;
        this.password = password;
        this.quit = quit;
        this.createDate = createDate;
    }

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(unique = true)
    private String email;
    private String password;

    private Boolean quit;//탈퇴여부
    private LocalDateTime createDate;

    //==생성 메서드==//
    public static Member createMember(String nickname, String email, String password) {
        return new Member(nickname, null, email, password, false, LocalDateTime.now());
    }
}
