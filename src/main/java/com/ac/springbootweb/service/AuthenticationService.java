package com.ac.springbootweb.service;

import com.ac.springbootweb.dto.LoginRequest;
import com.ac.springbootweb.dto.UserRequest;
import com.ac.springbootweb.entity.UserEntity;
import com.ac.springbootweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserEntity signup(UserRequest input) {
        return userRepository.save(UserEntity.builder()
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .status(1)
                .build());
    }

    public UserEntity authenticate(LoginRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

}
