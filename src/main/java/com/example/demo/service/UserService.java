package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
   void save(User user);
   void updated(User user);
   void delete(Integer id);
   List<User> findAll();
   User FindById(Integer id);
}
