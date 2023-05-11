package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username=:userName ")
    Optional<User> findUserByUserName(@Param("userName") String userName);
    
}
