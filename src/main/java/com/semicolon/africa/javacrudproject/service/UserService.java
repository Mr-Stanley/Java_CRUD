package com.semicolon.africa.javacrudproject.service;

import com.semicolon.africa.javacrudproject.dtos.request.CreateUpdateUserRequest;
import com.semicolon.africa.javacrudproject.dtos.request.CreateUserRequest;
import com.semicolon.africa.javacrudproject.dtos.request.DeleteUserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String CreateUser(CreateUserRequest createUserRequest);

    String UpdateUser(CreateUpdateUserRequest updateRequest);

    String DeleteUser(DeleteUserDetails deleteUserDetails);
}
