package com.ouaskanas.hahn.dto;

import com.ouaskanas.hahn.dao.entities.Roles;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    private String email;
    private String password;
    private String passwordConfirm;
    private String role;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public Roles getRole() {
        return Roles.valueOf(role);
    }

}
