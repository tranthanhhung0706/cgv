package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/reset-password")
public class PasswordResetController {

  // @Autowired
  // private JavaMailSender mailSender;

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<Object> resetPassword(@RequestParam String userName) {

    User user = userService.findUserByUsername(userName);

    if (user == null)
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    String otpCode = generateOTP();
    sendEmail(userName, otpCode);
    user.setPassword(otpCode);
    userService.save(user);
    return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Reset password successfully", user));
  }

  private String generateOTP() {

    int otp = new Random().nextInt(900000) + 100000;

    return String.valueOf(otp);
  }

  private void sendEmail(String email, String otpCode) {
    // create email message
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("your-email@gmail.com");
    message.setTo(email);
    message.setSubject("Password reset OTP code");
    message.setText("Your OTP code for resetting your password is: " + otpCode);

    // mailSender.send(message);
  }

}
