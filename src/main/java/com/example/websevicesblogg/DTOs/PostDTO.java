package com.example.websevicesblogg.DTOs;

import java.time.LocalDate;
import java.util.Date;

public class PostDTO {
    private Long id;
    private String postTitle;
    private String postText;
    private LocalDate dateForPost;
    private UserDTO userDTO;

    public PostDTO() {
    }

    public PostDTO(Long id, String postTitle, String postText, LocalDate dateForPost, UserDTO userDTO) {
        this.id = id;
        this.postTitle = postTitle;
        this.postText = postText;
        this.dateForPost = dateForPost;
        this.userDTO = userDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public LocalDate getDateForPost() {
        return dateForPost;
    }

    public void setDateForPost(LocalDate dateForPost) {
        this.dateForPost = dateForPost;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
