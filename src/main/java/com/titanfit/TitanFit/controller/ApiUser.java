package com.titanfit.TitanFit.controller;

import com.titanfit.TitanFit.model.User;
import com.titanfit.TitanFit.repository.UserRepositorty;
import com.titanfit.TitanFit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiUser {
    @Autowired
    private UserRepositorty userRepositorty;
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/api/user/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @PostMapping("/api/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/api/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/api/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
