package com.cloud.sendmessagekafka.core.domain;

import lombok.Builder;

@Builder
public class PostSummary implements Message {

    private Long postId;
    private String summary;
}
