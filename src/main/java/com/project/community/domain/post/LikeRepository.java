package com.project.community.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikeRepository {

    private final EntityManager em;

    public void save(Like like) {
        em.persist(like);
    }

    public void findOne(Long id) {
        em.find(Like.class, id);
    }

    public List<Like> findAllByPostId(Long postId) {
        return em.createQuery(
                "select l from Like l" +
                        " join fetch l.post p", Like.class
        ).getResultList();
    }
}
