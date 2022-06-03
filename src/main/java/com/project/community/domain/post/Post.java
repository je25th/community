package com.project.community.domain.post;

import com.project.community.domain.BaseEntity;
import com.project.community.domain.member.Member;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Post extends BaseEntity {

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
    private LocalDateTime deleteDate;

    //==생성 메서드==//
    public static Post createPost(Member member, String title, String content) {
        return new Post(member, title, content, LocalDateTime.now());
    }
}
