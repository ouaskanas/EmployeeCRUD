package com.ouaskanas.hahn.mappers;

import com.ouaskanas.hahn.dao.entities.Roles;
import com.ouaskanas.hahn.dao.entities.User;
import com.ouaskanas.hahn.dto.SignInDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public User ToModel(SignInDto signInDto) {
        User user = new User();
        user.setPassword(signInDto.getPassword());
        user.setUsername(signInDto.getEmail());
        user.setRole(signInDto.getRole());
        return user;
    }


}
