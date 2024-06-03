package com.example.websevicesblogg.repositories;

import com.example.websevicesblogg.enteties.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
