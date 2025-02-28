package com.semicolon.africa.javacrudproject.service;

import com.semicolon.africa.javacrudproject.dtos.request.CreateUpdateUserRequest;
import com.semicolon.africa.javacrudproject.dtos.request.CreateUserRequest;
import com.semicolon.africa.javacrudproject.dtos.request.DeleteUserDetails;
import com.semicolon.africa.javacrudproject.model.User;
import com.semicolon.africa.javacrudproject.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpli implements UserService {
    @Autowired
    private UserRespository userRepository;


    @Override
    public String CreateUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setName(createUserRequest.getName());
        userRepository.save(user);
        return "User created succesfully";

    }

    @Override
    public String UpdateUser(CreateUpdateUserRequest updateRequest) {
        User user = userRepository.findByEmail(updateRequest.getEmail());
        if(user == null) {
            return "User not found";
        }
            user.setName(updateRequest.getName());
            user.setEmail(updateRequest.getEmail());
            userRepository.save(user);
            return "User updated succesfully";



    }

    @Override
    public String DeleteUser(DeleteUserDetails deleteUserDetails) {
        User user = userRepository.findByEmail(deleteUserDetails.getEmail());
        if(user == null) {
            return "User not found";
        }
        user.setEmail(deleteUserDetails.getEmail());
        user.setName(deleteUserDetails.getName());
        userRepository.delete(user);
        return "User deleted succesfully";
    }
}
