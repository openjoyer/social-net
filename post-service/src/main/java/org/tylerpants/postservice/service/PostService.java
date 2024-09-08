package org.tylerpants.postservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tylerpants.postservice.model.Post;
import org.tylerpants.postservice.model.User;
import org.tylerpants.postservice.repository.PostRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findByUser(User user) {
        return postRepository.findByUser(user);
    }

    public Post findById(Integer id) {
        return postRepository.findById(id).orElse(null);
    }

    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public boolean delete(Integer id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            postRepository.delete(post);
            return true;
        }
        return false;
    }
}
