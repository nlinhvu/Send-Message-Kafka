package com.cloud.sendmessagekafka.adapter.messagereceiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PostCreatedEventSink {

    @StreamListener(PostSinkBinding.POSTS_IN)
    public void process(PostCreatedEvent event) {
        log.info("Received: " + event.toString());
    }
}
