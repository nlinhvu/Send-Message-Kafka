package com.cloud.sendmessagekafka.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Post implements Message {

    private Long id;
    private String title;
    private String content;
    private String summary;

    public static Post withId(Long id, String title, String content, String summary) {
        return new Post(id, title, content, summary);
    }

    public static Post withoutId(String title, String content, String summary) {
        return new Post(null, title, content, summary);
    }
}
