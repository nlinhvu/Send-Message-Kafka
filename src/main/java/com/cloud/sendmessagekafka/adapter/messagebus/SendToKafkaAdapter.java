package com.cloud.sendmessagekafka.adapter.messagebus;

import com.cloud.sendmessagekafka.application.port.out.SendPostToKafka;
import com.cloud.sendmessagekafka.common.BusAdapter;
import com.cloud.sendmessagekafka.core.domain.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@BusAdapter
@Slf4j
class SendToKafkaAdapter implements SendPostToKafka {

    private final MessageChannel postsOut;

    public SendToKafkaAdapter(PostSourceBinding binding) {
        this.postsOut = binding.postsOut();
    }

    @Override
    public void send(Post post) {
        PostCreatedEvent event = new PostCreatedEvent(post.getId().toString(), post.getTitle());
        Message<PostCreatedEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.MESSAGE_KEY, event.getId().getBytes())
                .build();
        try {
            this.postsOut.send(message);
            log.info("Sent: " + message.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
