package com.example.websevicesblogg.enteties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String postTitle;
    @Column(nullable = false)
    private String postText;
    @Column(nullable = false)
    private LocalDate dateForPost;

    @JsonIgnoreProperties({"posts"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private User user;


    public Post() {
    }

    public Post(String postTitle, String postText, LocalDate dateForPost, User user) {
        this.postTitle = postTitle;
        this.postText = postText;
        this.dateForPost = dateForPost;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
