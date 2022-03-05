package com.project.community.domain.post;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class LikeId implements Serializable {

    private Long memberId;
    private Long postId;

    public Long getMemberId() {
        return memberId;
    }

    public Long getPostId() {
        return postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeId likeId = (LikeId) o;
        return Objects.equals(getMemberId(), likeId.getMemberId()) && Objects.equals(getPostId(), likeId.getPostId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId(), getPostId());
    }
}
