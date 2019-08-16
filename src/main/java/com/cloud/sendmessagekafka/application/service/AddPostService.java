package com.cloud.sendmessagekafka.application.service;

import com.cloud.sendmessagekafka.application.port.in.AddPostUseCase;
import com.cloud.sendmessagekafka.application.port.out.SavePostIntoDBPort;
import com.cloud.sendmessagekafka.application.port.out.SendPostToKafka;
import com.cloud.sendmessagekafka.common.UseCase;
import com.cloud.sendmessagekafka.core.domain.Post;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
class AddPostService implements AddPostUseCase {

    private final SavePostIntoDBPort savePostIntoDBPort;
    private final SendPostToKafka sendPostToKafka;

    @Override
    public void addPost(AddPostCommand command) {
        Post post = Post.withoutId(
                command.getTitle(),
                command.getContent(),
                command.getSummary());

        Post postWithId = savePostIntoDBPort.save(post);
        sendPostToKafka.send(postWithId);
    }
}
