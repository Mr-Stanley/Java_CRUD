package com.semicolon.africa.javacrudproject.repository;

import com.semicolon.africa.javacrudproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends MongoRepository<User,String> {

    User findByEmail(String email);
}
