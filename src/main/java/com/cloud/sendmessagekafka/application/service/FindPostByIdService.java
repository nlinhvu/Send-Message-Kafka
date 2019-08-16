package com.cloud.sendmessagekafka.application.service;

import com.cloud.sendmessagekafka.application.port.in.FindPostByIdQuery;
import com.cloud.sendmessagekafka.application.port.out.FindPostByIdPort;
import com.cloud.sendmessagekafka.common.UseCase;
import com.cloud.sendmessagekafka.core.domain.Post;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
class FindPostByIdService implements FindPostByIdQuery {

    private final FindPostByIdPort findPostByIdPort;

    @Override
    public Post find(Long id) {
        return findPostByIdPort.find(id);
    }
}
