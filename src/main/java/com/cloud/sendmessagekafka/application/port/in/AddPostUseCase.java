package com.cloud.sendmessagekafka.application.port.in;

import com.cloud.sendmessagekafka.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

public interface AddPostUseCase {
    void addPost(AddPostCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class AddPostCommand extends SelfValidating<AddPostCommand> {
        @NotEmpty
        private String title;

        @NotEmpty
        private String content;

        @NotEmpty
        private String summary;

        public AddPostCommand(String title, String content, String summary) {
            this.title = title;
            this.content = content;
            this.summary = summary;
            validateSelf();
        }
    }
}
