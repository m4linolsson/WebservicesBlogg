package com.example.websevicesblogg.controllers;

import com.example.websevicesblogg.DTOs.PostDTO;
import com.example.websevicesblogg.enteties.Post;
import com.example.websevicesblogg.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }


    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }


    @PostMapping("/newpost")
    @PreAuthorize("hasRole('blogg_user')")
    public ResponseEntity<String> addNewPost(@RequestBody Post post, Principal principal) {
        postService.addNewPost(post, principal);
        return ResponseEntity.ok("Post posted on blogg");
    }


    @PutMapping("/updatepost/{id}")
    @PreAuthorize("hasRole('blogg_user')")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post post, Principal principal) {
        return ResponseEntity.ok(postService.updatePost(id, post, principal));
    }

    @DeleteMapping("/deletepost/{id}")
    @PreAuthorize("hasRole('blogg_user')")
    public ResponseEntity<String> deletePost(@PathVariable Long id, Principal principal) {
        postService.deletePost(id, principal);
        return ResponseEntity.ok("Post with id:" + id + " deleted");
    }

}
