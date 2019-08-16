package com.cloud.sendmessagekafka.adapter.api;

import com.cloud.sendmessagekafka.application.port.in.AddPostUseCase;
import com.cloud.sendmessagekafka.application.port.in.AddPostUseCase.AddPostCommand;
import com.cloud.sendmessagekafka.application.port.in.FindPostByIdQuery;
import com.cloud.sendmessagekafka.core.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/posts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
class PostController {

    private final AddPostUseCase addPostUseCase;
    private final FindPostByIdQuery findPostByIdQuery;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody AddPostRequest request) {
        AddPostCommand command = new AddPostCommand(request.getTitle(), request.getContent(), request.getSummary());
        addPostUseCase.addPost(command);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable Long id) {
        Post post = findPostByIdQuery.find(id);
        PostResponse postResponse = new PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getSummary());
        return ResponseEntity.ok(postResponse);
    }
}

