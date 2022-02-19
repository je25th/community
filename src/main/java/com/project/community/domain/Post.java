package com.project.community.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Post {

    protected Post(Member member, String title, String content, LocalDateTime createDate) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
    }

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    //==생성 메서드==//
    public Post createPost(Member member, String title, String content) {
        return new Post(member, title, content, LocalDateTime.now());
    }
}
