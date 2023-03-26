package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.security.UserPrinciple;

public interface AuthenticationService {
    UserPrinciple getCurrenUser();

    Role getCurrenUsersRole();
}
