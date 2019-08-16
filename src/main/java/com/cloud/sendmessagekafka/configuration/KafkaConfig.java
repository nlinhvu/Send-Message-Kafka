package com.cloud.sendmessagekafka.configuration;

import com.cloud.sendmessagekafka.adapter.messagebus.PostSourceBinding;
import com.cloud.sendmessagekafka.adapter.messagereceiver.PostSinkBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({
        PostSourceBinding.class,
        PostSinkBinding.class
})
public class KafkaConfig {
}
