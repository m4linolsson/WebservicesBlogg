package com.example.websevicesblogg.services;

import com.example.websevicesblogg.DTOs.PostDTO;
import com.example.websevicesblogg.DTOs.UserDTO;
import com.example.websevicesblogg.enteties.Post;
import com.example.websevicesblogg.enteties.User;
import com.example.websevicesblogg.exceptions.FalseUserException;
import com.example.websevicesblogg.exceptions.ResourceNotFoundException;
import com.example.websevicesblogg.repositories.PostRepository;
import com.example.websevicesblogg.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class PostService implements PostServiceInterface {
    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::convertToPostDTO).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return convertToPostDTO(post);
    }

    @Override
    public void addNewPost(Post post, Principal principal) {
        String loggedInUserName = principal.getName();
        if (userRepository.existsByUserName(loggedInUserName)) {
            User userForPost = userRepository.findByUserName(loggedInUserName);
            post.setUser(userForPost);
            post.setDateForPost(LocalDate.now());
            postRepository.save(post);
        } else throw new ResourceNotFoundException("User", "username", loggedInUserName);
    }

    @Override
    public Post updatePost(Long postId, Post post, Principal principal) {
        String loggedInUserName = principal.getName();
        Post postToUpdate = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        User userFromPostToUpdate = userRepository.findById(postToUpdate.getUser().getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", postToUpdate.getUser().getId()));

        if (loggedInUserName.equals(userFromPostToUpdate.getUserName())) {
            postToUpdate.setPostTitle(post.getPostTitle());
            postToUpdate.setPostText(post.getPostText());
            postToUpdate.setDateForPost(LocalDate.now());
            return postRepository.save(postToUpdate);
        } else throw new FalseUserException("update");
    }

    @Override
    public void deletePost(Long id, Principal principal) {
        Post postToDelete = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        if (postToDelete.getUser().getUserName().equals(principal.getName())) {
            postRepository.deleteById(id);
        } else throw new FalseUserException("delete");
    }


    private PostDTO convertToPostDTO(Post post) {
        UserDTO userDTO = new UserDTO(post.getUser().getUserName());
        return new PostDTO(post.getId(), post.getPostTitle(), post.getPostText(), post.getDateForPost(), userDTO);
    }
}
