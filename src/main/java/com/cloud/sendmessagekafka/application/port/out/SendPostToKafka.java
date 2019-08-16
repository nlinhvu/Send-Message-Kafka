package com.cloud.sendmessagekafka.application.port.out;

import com.cloud.sendmessagekafka.core.domain.Post;

public interface SendPostToKafka {
    void send(Post post);
}
