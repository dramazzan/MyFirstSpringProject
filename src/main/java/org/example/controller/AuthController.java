package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.JwtAuthToken;
import org.example.dto.LoginDto;
import org.example.dto.RegisterDto;
import org.example.model.User;
import org.example.service.AuthService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;


    @GetMapping("/loginpage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registerpage")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute LoginDto dto) throws ServletException, IOException {
        authService.loginUser(dto);
         return "profile";
    }


    @PostMapping("/register")
    public String registerUser( @ModelAttribute RegisterDto dto) {
         authService.registerUser(dto);
         return "redirect:/auth/loginpage";
    }

    @PostMapping("/logout")
    public String logoutUser() {
        authService.logoutUser();
        return "redirect:/auth/loginpage";
    }

}

