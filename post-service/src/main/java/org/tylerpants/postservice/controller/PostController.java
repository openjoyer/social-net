package org.tylerpants.postservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tylerpants.postservice.dto.PostDTO;
import org.tylerpants.postservice.kafka.KafkaProducer;
import org.tylerpants.postservice.model.Post;
import org.tylerpants.postservice.service.PostService;
import org.tylerpants.postservice.util.PostMapper;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;
    private final KafkaProducer kafkaProducer;

    @Autowired
    public PostController(PostService postService, PostMapper postMapper, KafkaProducer kafkaProducer) {
        this.postService = postService;
        this.postMapper = postMapper;
        this.kafkaProducer = kafkaProducer;
    }

    /**
     * СДЕЛАТЬ ОТПРАВКУ НОТИФИКАЦИЙ НА ПОЧТУ!!!
     * @param postDTO
     * @return ResponseEntity
     */
    @PostMapping("/new")
    public ResponseEntity<?> newPost(@RequestBody PostDTO postDTO) {
        Post post = postMapper.toModel(postDTO);
        if(postService.save(post) == null) {
            return new ResponseEntity<>("Post not saved!", HttpStatus.BAD_REQUEST);
        } else {
            kafkaProducer.send("notification", "User" + post.getUser().getUsername() + " created new post!");
            return new ResponseEntity<>("Post saved successfully!", HttpStatus.CREATED);
        }
    }
}
