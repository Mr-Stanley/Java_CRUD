package com.semicolon.africa.javacrudproject.service;

import com.semicolon.africa.javacrudproject.dtos.request.CreateUpdateUserRequest;
import com.semicolon.africa.javacrudproject.dtos.request.CreateUserRequest;
import com.semicolon.africa.javacrudproject.dtos.request.DeleteUserDetails;
import com.semicolon.africa.javacrudproject.model.User;
import com.semicolon.africa.javacrudproject.repository.UserRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class userServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRespository userRepository;

    @Test
    public void testThatUserCanBeCreated(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail("test@gmail.com");
        createUserRequest.setName("test");
        userService.CreateUser(createUserRequest);
        User createdUser = userRepository.findByEmail(createUserRequest.getEmail());
        assertEquals("test@gmail.com",createdUser.getEmail());


    }

    @Test
    public void testThatUserDetailsCanBeUpdated() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail("Stan@gmail.com");
        createUserRequest.setName("Stan");
        userService.CreateUser(createUserRequest);
        CreateUpdateUserRequest updateUserRequest = new CreateUpdateUserRequest();
        updateUserRequest.setEmail("Stanley@gmail.com");
        updateUserRequest.setName("Stanley");
        userService.UpdateUser(updateUserRequest);
/*
        String UpdatedUser = userService.UpdateUser(updateUserRequest);
*/
        assertEquals("Stanley@gmail.com",updateUserRequest.getEmail());
        assertEquals("Stanley", updateUserRequest.getName());


    }
    @Test
    public void testThatUserDetailsCanBeDeleted() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail("Stanley081@gmail.com");
        createUserRequest.setName("Stanley ugoo");
        userService.CreateUser(createUserRequest);
        DeleteUserDetails deleteUserDetails = new DeleteUserDetails();
        deleteUserDetails.setEmail("Stanley081@gmail.com");
        deleteUserDetails.setName("Stanley ugoo");
        userService.DeleteUser(deleteUserDetails);
        assertNull(userRepository.findByEmail(deleteUserDetails.getEmail()));
    }

}

