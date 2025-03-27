package com.ac.springbootweb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {
    private String email;
    private String password;
    private String name;
    private String lastname;
    private Date birthday;
    private boolean gender;
}
