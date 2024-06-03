package com.example.websevicesblogg.services;

import com.example.websevicesblogg.DTOs.PostDTO;
import com.example.websevicesblogg.enteties.Post;

import java.security.Principal;
import java.util.List;

public interface PostServiceInterface {


    List<PostDTO> getAllPosts();

    PostDTO getPostById(Long id);

    void addNewPost(Post post, Principal principal);

    Post updatePost(Long id, Post post, Principal principal);

    void deletePost(Long id, Principal principal);

}
