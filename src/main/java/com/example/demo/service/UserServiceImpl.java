package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    
  
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void updated(User user) {
		// TODO Auto-generated method stub
		User olduser=userRepository.getById(user.getId());
		System.out.println(olduser.getId());
		User newuser=new User();
			newuser.setId(olduser.getId());
			newuser.setFullName(olduser.getFullName());
			newuser.setUsername(olduser.getUsername());
			newuser.setPassword(olduser.getPassword());
			userRepository.save(newuser);
	}

	@Override
	public User FindById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}


    

}
