package com.ouaskanas.hahn.controller;

import com.ouaskanas.hahn.dao.entities.User;
import com.ouaskanas.hahn.dao.repository.UserRepository;
import com.ouaskanas.hahn.dto.LoginDto;
import com.ouaskanas.hahn.dto.SignInDto;
import com.ouaskanas.hahn.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignInDto signInDto) {
        userService.register(signInDto);
        return ResponseEntity.status(HttpStatus.OK).body("user created");
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto);
    }
}
