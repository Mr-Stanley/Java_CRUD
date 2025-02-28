package com.semicolon.africa.javacrudproject.service;

import com.semicolon.africa.javacrudproject.dtos.request.CreateUserRequest;
import com.semicolon.africa.javacrudproject.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpli implements UserService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRespository userRepository;


    @Override
    public void CreateUser(CreateUserRequest createUserRequest) {

    }
}
