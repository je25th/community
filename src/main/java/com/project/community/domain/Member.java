package com.project.community.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String accountId;
    private boolean quit;
    private LocalDateTime createDate;

    @OneToMany(fetch = LAZY)
    private List<Like> likes = new ArrayList<>();
}
