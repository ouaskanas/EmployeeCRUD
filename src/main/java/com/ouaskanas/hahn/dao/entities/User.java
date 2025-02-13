package com.ouaskanas.hahn.dao.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
