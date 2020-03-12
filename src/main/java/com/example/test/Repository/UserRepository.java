package com.example.test.Repository;

import com.example.test.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByName(String name);

    void deleteByName(String name);
}
