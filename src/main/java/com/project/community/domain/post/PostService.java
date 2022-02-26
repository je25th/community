package com.project.community.domain.post;

import com.project.community.domain.member.Member;
import com.project.community.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Long write(Long memberId, String title, String content) {

        Member member = memberRepository.findOne(memberId);
        Post post = Post.createPost(member, title, content);
        postRepository.save(post);

        return post.getId();
    }

    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }

}
