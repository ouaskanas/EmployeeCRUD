package com.ouaskanas.hahn.dto;


public class AuthResponseDto {
    private String token;
    private String tokenType ="Bearer ";

    public AuthResponseDto(String token) {
        this.token = token;
    }
}
