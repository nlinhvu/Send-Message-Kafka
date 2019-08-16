package com.cloud.sendmessagekafka.adapter.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class AddPostRequest {
    private String title;
    private String content;
    private String summary;
}
