package org.tylerpants.postservice.util;

import org.springframework.stereotype.Component;
import org.tylerpants.postservice.dto.PostDTO;
import org.tylerpants.postservice.model.Post;

import java.time.LocalDateTime;

@Component
public class PostMapper implements DtoMapper<PostDTO, Post> {

    @Override
    public PostDTO toDto(Post model) {
        return new PostDTO(model.getDescription(), model.getUser());
    }

    @Override
    public Post toModel(PostDTO dto) {
        Post post = new Post();
        post.setDescription(dto.getDescription());
        post.setUser(dto.getUser());
        post.setCreatedAt(LocalDateTime.now());
        return post;
    }
}
