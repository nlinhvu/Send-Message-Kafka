package com.cloud.sendmessagekafka.adapter.messagebus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class PostCreatedEvent {
    private String id;
    private String title;
}
