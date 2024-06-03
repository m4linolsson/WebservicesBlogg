package com.example.websevicesblogg.repositories;

import com.example.websevicesblogg.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String userName);

    User findByUserName(String userName);
}
