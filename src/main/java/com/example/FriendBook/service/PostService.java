package com.example.FriendBook.service;

import com.example.FriendBook.dto.requestDTO.PostRequest;
import com.example.FriendBook.dto.responseDTO.PostResponse;
import com.example.FriendBook.exception.NotFoundException;
import com.example.FriendBook.model.Post;
import com.example.FriendBook.model.User;
import com.example.FriendBook.repository.PostRepository;
import com.example.FriendBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost(int userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        post.setUser(user);
        return postRepository.save(post);
    }


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post not found"));
    }

    public Post updatePost(int postId, Post updatedPost) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post not found"));

        // Update fields based on the updatedPost
        // For example: post.setTitle(updatedPost.getTitle());
        // Save the updated post
        return postRepository.save(post);
    }

    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }
}
