package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.JwtAuthToken;
import org.example.dto.LoginDto;
import org.example.dto.RegisterDto;
import org.example.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public JwtAuthToken loginUser(@RequestBody LoginDto dto) {
        return authService.loginUser(dto);
    }


    @PostMapping("/register")
    public JwtAuthToken registerUser(@RequestBody RegisterDto dto) {
        return authService.registerUser(dto);
    }

}

