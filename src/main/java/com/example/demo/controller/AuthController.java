package com.example.demo.controller;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.model.User;

import com.example.demo.security.jwt.JwtResponse;
import com.example.demo.security.jwt.JwtService;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.CustomerService;

import java.io.Console;
import java.nio.file.attribute.UserPrincipal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtService.generateTokenLogin(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User currentUser = userService.findUserByUsername(user.getUsername());
            System.out.println(userDetails.getAuthorities());
            String[] roles = userDetails.getAuthorities().stream()
                                    .map(GrantedAuthority::getAuthority)
                                    .toArray(String[]::new);
            return ResponseEntity.ok(
                    new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getFullName(),roles));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(HttpStatus.UNAUTHORIZED, "Incorrect username or password."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred during login."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO UserDTO) {
        try {
            // System.out.println("testRegister" +
            // userService.findByUsername(UserDTO.getUsername()).toString());
            if (userService.findByUsername(UserDTO.getUsername()).isPresent()) {
                throw new Exception("Đã tồn tại người dùng, vui lòng chọn tên đăng nhập khác");
            }
            // UserDTO.getUsername(), UserDTO.getPassword(), UserDTO.getFullName(),
            // UserDTO.getRoles()

            User user = new User();
            user.setFullName(UserDTO.getFullName());
            user.setUsername(UserDTO.getUsername());
            user.setPassword(UserDTO.getPassword());
            // user.setRoles(UserDTO.getRoles());

            // System.out.println("test" + UserDTO.getRoles());

            Set<Role> roles = UserDTO.getRoles();

            for (Role role : roles) {
                Role existingRole = roleRepository.findByName(role.getName());
                user.getRoles().add(existingRole);
            }

            String password = user.getPassword();

            userService.save(user);

            Customer customer = new Customer(UserDTO.getFullName(), UserDTO.getBirthday(), UserDTO.getPhone_number(),
                    UserDTO.getAddress());
            customer.setUser(user);

            customerService.save(customer);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), password));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtService.generateTokenLogin(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User currentUser = userService.findByUsername(user.getUsername()).get();
            return ResponseEntity.ok(
                    new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), currentUser.getFullName()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                            "An error occurred during registration."));
        }

    }

}
