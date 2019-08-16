package com.cloud.sendmessagekafka.adapter.persistence;

import com.cloud.sendmessagekafka.application.port.out.FindPostByIdPort;
import com.cloud.sendmessagekafka.application.port.out.SavePostIntoDBPort;
import com.cloud.sendmessagekafka.common.PersistenceAdapter;
import com.cloud.sendmessagekafka.core.domain.Post;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@PersistenceAdapter
@RequiredArgsConstructor
class PostPersistenceAdapter implements SavePostIntoDBPort, FindPostByIdPort {

    private final PostRepository postRepository;

    @Override
    public Post save(Post post) {
        PostJpaEntity postJpaEntity = new PostJpaEntity(null, post.getTitle(), post.getContent(), post.getSummary());
        PostJpaEntity postJpaEntityWithId = postRepository.save(postJpaEntity);
        return Post.withId(
                postJpaEntityWithId.getId(),
                postJpaEntityWithId.getTitle(),
                postJpaEntityWithId.getContent(),
                postJpaEntityWithId.getSummary());
    }

    @Override
    public Post find(Long id) {
        PostJpaEntity postJpaEntity = postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return Post.withId(
                postJpaEntity.getId(),
                postJpaEntity.getTitle(),
                postJpaEntity.getContent(),
                postJpaEntity.getSummary());
    }
}
