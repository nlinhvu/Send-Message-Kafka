package com.cloud.sendmessagekafka.adapter.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String summary;
}
