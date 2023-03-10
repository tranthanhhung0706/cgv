package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.User;

public interface UserService extends  UserDetailsService {
   void save(User user);
   void updated(User user);
   void delete(Integer id);
   List<User> findAll();

   User FindById(Integer id);

   UserDetails loadUserByUsername(String username);
   Optional<User> findByUsername(String username);
   
}
