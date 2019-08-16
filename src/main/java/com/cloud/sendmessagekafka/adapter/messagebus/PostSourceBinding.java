package com.cloud.sendmessagekafka.adapter.messagebus;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PostSourceBinding {

    String POSTS_OUT = "psout";

    @Output(POSTS_OUT)
    MessageChannel postsOut();

}
