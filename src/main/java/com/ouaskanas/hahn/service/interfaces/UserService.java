package com.ouaskanas.hahn.service.interfaces;

import com.ouaskanas.hahn.dao.entities.User;
import com.ouaskanas.hahn.dto.LoginDto;
import com.ouaskanas.hahn.dto.SignInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public ResponseEntity<?> login(LoginDto loginDto);
    public User register(SignInDto signInDto);
}
