package com.titanfit.TitanFit.service;

import com.titanfit.TitanFit.model.User;
import com.titanfit.TitanFit.repository.UserRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositorty userRepositorty;

    public List<User> findAll() {
        return this.userRepositorty.findAll();
    }

    public User findById(String id) {
        User User=null;
        Optional<User> user = this.userRepositorty.findById(id);
        if (user.isPresent()) {
            User=user.get();
        }
        return User;
    }

    public User save(User user) {
        return this.userRepositorty.save(user);
    }

    public void delete(User user) {
        this.userRepositorty.delete(user);
    }
}
