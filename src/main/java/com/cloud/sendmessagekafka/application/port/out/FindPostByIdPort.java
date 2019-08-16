package com.cloud.sendmessagekafka.application.port.out;

import com.cloud.sendmessagekafka.core.domain.Post;

public interface FindPostByIdPort {

    Post find(Long id);
}
