package com.example.demo.security.jwt;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.model.Role;

public class JwtResponse {
    private Integer id;
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private String name;
    private String[] roles;


   

    public JwtResponse(String accessToken, Integer id, String username, String name) {
        this.accessToken = accessToken;
        this.username = username;
        this.name = name;
        this.id = id;
    }

    public JwtResponse(String accessToken, Integer id, String username, String name,
    String[] roles) {
        this.accessToken = accessToken;
        this.username = username;
        this.name = name;
        this.id = id;
        this.roles = roles;
    }
    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

}
