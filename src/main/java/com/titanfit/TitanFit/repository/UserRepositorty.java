package com.titanfit.TitanFit.repository;

import com.titanfit.TitanFit.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepositorty extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
