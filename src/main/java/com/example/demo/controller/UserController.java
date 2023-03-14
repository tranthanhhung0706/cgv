package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;


@CrossOrigin(origins = "http://localhost:3006")
@RestController
public class UserController {
	public List<User> users=new ArrayList<User>();
	@Autowired UserService userService;
//	@PostMapping("/user")
//	public User create(@RequestBody User user) {
//		userService.save(user);
//		return user;
//	}
	@GetMapping("/user")
	public List<UserDTO> getAll(){
		return userService.findAllUser();
	}
//	@GetMapping("/user/{id}")
//	public User getUserById(@PathVariable int id) {
//		User hung= userService.FindById(id);
//		try {
//			System.out.println(hung.getUsername());
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("error");
//		}
//		
//		return userService.FindById(id);
//				
//	}
//	@DeleteMapping("/user/{id}")
//	public List<User> delete(@PathVariable int id) {
//		if (userService.FindById(id).getId()!=null) {
//			userService.delete(id);
//		}
//		return userService.findAll();
//	}
//	@PutMapping("/user/{id}")
//	public User update(@RequestBody User user,@PathVariable int id) {
//		try {
//			if (userService.FindById(id).getId()!=null) {
//				user.setId(id);
//				userService.save(user);
//			}
//			return user;
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//	}
}
