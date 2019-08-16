package com.cloud.sendmessagekafka.adapter.messagereceiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PostSinkBinding {

    String POSTS_IN = "psin";

    @Input(POSTS_IN)
    SubscribableChannel postsIn();
}
