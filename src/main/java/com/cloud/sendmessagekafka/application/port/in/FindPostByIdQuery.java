package com.cloud.sendmessagekafka.application.port.in;

import com.cloud.sendmessagekafka.core.domain.Post;

public interface FindPostByIdQuery {
    Post find(Long id);
}
