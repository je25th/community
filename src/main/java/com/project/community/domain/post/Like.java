package com.project.community.domain.post;

import com.project.community.domain.BaseEntity;
import com.project.community.domain.member.Member;
import com.project.community.domain.post.LikeId;
import com.project.community.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "likes")
@Getter
@NoArgsConstructor
public class Like extends BaseEntity {

    @EmbeddedId
    private LikeId id;

    @MapsId("memberId")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @MapsId("postId")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
