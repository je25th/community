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
    public int hashCode() {
        return Objects.hash(memberId, postId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || !(this instanceof LikeId)) return false;
        LikeId likeId = (LikeId) obj;
        return this.memberId == likeId.memberId && this.postId == likeId.postId;
    }
}
