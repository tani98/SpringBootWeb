package com.ac.springbootweb.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
