package com.titanfit.TitanFit.repository;

import com.titanfit.TitanFit.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositorty extends MongoRepository<User, String> {
}
