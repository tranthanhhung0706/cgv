package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.UserPrinciple;
import com.example.demo.convert.UserConvert;
import com.example.demo.dto.UserDTO;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
	UserRepository userRepository;
	
    @Autowired
    CustomerRepository customerRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
    
	@Autowired
	UserConvert userConvert;
  
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()  ));
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<UserDTO> findAllUser() {
		// TODO Auto-generated method stub
		List<User> listuser=userRepository.findAll();
		List<UserDTO> liUserDTOs=new ArrayList<UserDTO>();
		for(int i=0;i<listuser.size();i++) {
			liUserDTOs.add(userConvert.toDto(listuser.get(i), customerRepository.findAll().get(i)));
		}
		return liUserDTOs;
	}

	@Override
	public void updated(User user) {
		// TODO Auto-generated method stub
		User olduser = userRepository.getById(user.getId());
		System.out.println(olduser.getId());
		User newuser = new User();
		newuser.setId(olduser.getId());
		newuser.setFullName(olduser.getFullName());
		newuser.setUsername(olduser.getUsername());
		newuser.setPassword(olduser.getPassword());
		userRepository.save(newuser);
	}
	

	@Override
	public User FindById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);

	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByUsername(username);
		if (!userOptional.isPresent()) {
			throw new UsernameNotFoundException(username);
		}
		return UserPrinciple.build(userOptional.get());
	}
	
	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findUserByUsername(String userName) {
		  Optional<User> user =  userRepository.findUserByUserName(userName);
			return user.orElse(null);
	}

	@Override
	public void resetPassword(String username) {
		User user = findUserByUsername(username);
		if (user == null) {

		}
	}
	
	
	
	


    

}
