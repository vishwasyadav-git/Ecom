package com.userservice.controllers;

import com.userservice.dtos.LoginRequestDto;
import com.userservice.dtos.LoginResponseDto;
import com.userservice.dtos.SignUpRequestDto;
import com.userservice.dtos.SignUpResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/sign_up")
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto){

        return null;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(){
        return null;
    }
}
