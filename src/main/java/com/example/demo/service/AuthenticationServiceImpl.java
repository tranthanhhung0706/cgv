package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.security.UserPrinciple;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public UserPrinciple getCurrenUser() {
        // TODO Auto-generated method stub

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserPrinciple) {
            return (UserPrinciple) principal;
        }
        return null;
    }

    @Override
    public Role getCurrenUsersRole() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrenUsersRole'");
    }

}
