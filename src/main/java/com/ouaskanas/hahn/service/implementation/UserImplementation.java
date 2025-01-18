package com.ouaskanas.hahn.service.implementation;

import com.ouaskanas.hahn.dao.entities.User;
import com.ouaskanas.hahn.dao.repository.UserRepository;
import com.ouaskanas.hahn.dto.AuthResponseDto;
import com.ouaskanas.hahn.dto.LoginDto;
import com.ouaskanas.hahn.dto.SignInDto;
import com.ouaskanas.hahn.mappers.UserMapper;
import com.ouaskanas.hahn.security.JwtGenerator;
import com.ouaskanas.hahn.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> login(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken test = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword());
        System.out.println("hello " + loginDto.getUsername());
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            System.out.println(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generateToken(authentication);
            return new ResponseEntity<AuthResponseDto>(new AuthResponseDto(token), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>("Username or password is Wrong ! "+e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public User register(SignInDto signInDto) {
        if(userRepository.findByUsername(signInDto.getEmail())!=null){
            throw new IllegalArgumentException("email already used !");
        }
        User user = userMapper.ToModel(signInDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
