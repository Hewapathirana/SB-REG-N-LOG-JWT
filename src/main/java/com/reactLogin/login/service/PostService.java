package com.reactLogin.login.service;

import com.reactLogin.login.model.Post;
import com.reactLogin.login.model.Profile;
import com.reactLogin.login.model.User;
import com.reactLogin.login.payload.PostRequest;
import com.reactLogin.login.repository.PostRepository;
import com.reactLogin.login.repository.ProfileRepository;
import com.reactLogin.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public Post addPost(PostRequest postRequest, Principal principal) {
        User user = userRepository.findByUsername(postRequest.getUsername());
        Profile profile = profileRepository.findByUser(user);
        Post post = new Post();
        post.setText(postRequest.getText());
        post.setProfile(profile);
        return postRepository.save(post);

    }

    public List<Post> getPost() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(String p_id) {
        return postRepository.findById(Long.valueOf(p_id));
    }
}
