package com.project.community.domain.member;

import com.project.community.domain.post.Like;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    protected Member(String nickname, AccountType accountType, String email, String password, Boolean quit, LocalDateTime joinDate) {
        this.nickname = nickname;
        this.accountType = accountType;
        this.email = email;
        this.password = password;
        this.quit = quit;
        this.joinDate = joinDate;
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
    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "member")
    private List<Like> likes = new ArrayList<>();

    //==생성 메서드==//
    public static Member createMember(String nickname, String email, String password) {
        return new Member(nickname, null, email, password, false, LocalDateTime.now());
    }
}
