package com.project.community.domain.post;

import com.project.community.domain.member.Member;
import com.project.community.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final LikeRepository likeRepository;

    public Long write(Long memberId, String title, String content) {

        Member member = memberRepository.findOne(memberId);
        Post post = Post.createPost(member, title, content);
        postRepository.save(post);

        return post.getId();
    }

    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }

    public Long likeThis(Long memberId, Long postId) {
        Member member = memberRepository.findOne(memberId);
        Post post = postRepository.findOne(postId);
        Like like = new Like(null, member, post, LocalDateTime.now());
        likeRepository.save(like);

        return like.getId();
    }

    public List<Like> findAllLikeByPostId(Long postId) {
        return likeRepository.findAllByPostId(postId);
    }

}
