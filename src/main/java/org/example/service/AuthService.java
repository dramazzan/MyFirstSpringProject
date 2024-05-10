package org.example.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.dto.JwtAuthToken;
import org.example.dto.LoginDto;
import org.example.dto.RegisterDto;
import org.example.model.Role;
import org.example.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final HttpServletResponse httpServletResponse;

    public JwtAuthToken registerUser(RegisterDto dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .role(Role.ROLE_USER)
                .password(passwordEncoder.encode(dto.getPassword()))
                .age(Integer.parseInt(dto.getAge()))
                .build();

        userService.createUser(user);
        String token = jwtService.generateToken(user);
        return new JwtAuthToken(token);
    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect("/auth/loginpage");
    }

    public JwtAuthToken loginUser(LoginDto dto) throws ServletException, IOException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    dto.getUsername(),
                    dto.getPassword()
            ));
        }catch(AuthenticationException e){
            onAuthenticationFailure(null, httpServletResponse , e);
            return null;
        }



        var user = userService
                .userDetailsService()
                .loadUserByUsername(dto.getUsername());

        var token = jwtService.generateToken(user);
        return new JwtAuthToken(token);

    }

    public void logoutUser() {
        SecurityContextHolder.clearContext();
    }

}

