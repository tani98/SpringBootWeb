package com.ac.springbootweb.restful;

import com.ac.springbootweb.dto.LoginRequest;
import com.ac.springbootweb.dto.LoginResponse;
import com.ac.springbootweb.dto.UserRequest;
import com.ac.springbootweb.entity.UserEntity;
import com.ac.springbootweb.service.AuthenticationService;
import com.ac.springbootweb.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRest {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseEntity<UserEntity> register(@RequestBody UserRequest registerUserDto) {
        UserEntity registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginUserDto) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        return ResponseEntity.ok(LoginResponse.builder()
                .token(jwtToken)
                .build());
    }
}
