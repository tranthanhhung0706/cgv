package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.User;

@Component
public class UserConvert {
    public UserDTO toDto(User user,Customer customer) {
    	UserDTO userDTO=new UserDTO();
    	userDTO.setUsername(user.getUsername());
   	    userDTO.setFullName(user.getFullName());
    	userDTO.setPassword(user.getPassword());
    	userDTO.setAddress(customer.getAddress());
    	userDTO.setBirthday(customer.getBirthday());
    	userDTO.setPhone_number(customer.getPhone_number());
    	userDTO.setRoles(user.getRoles());
    	return userDTO;
    }
}
