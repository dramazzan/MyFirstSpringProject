package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.JwtAuthToken;
import org.example.dto.LoginDto;
import org.example.dto.RegisterDto;
import org.example.model.Role;
import org.example.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

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

    public JwtAuthToken loginUser(LoginDto dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(dto.getUsername());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthToken(jwt);

    }

}

