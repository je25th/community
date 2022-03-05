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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeId likeId = (LikeId) o;
        return Objects.equals(memberId, likeId.memberId) && Objects.equals(postId, likeId.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, postId);
    }
}
