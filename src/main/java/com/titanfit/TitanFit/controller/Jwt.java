package com.titanfit.TitanFit.controller;

import com.titanfit.TitanFit.model.User;
import com.titanfit.TitanFit.repository.UserRepositorty;
import com.titanfit.TitanFit.service.JwtService;
import com.titanfit.TitanFit.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class Jwt {

    @Autowired
    private UserInfoService service;

    private UserRepositorty usuarioRepository;

    @Autowired
    public Jwt(UserRepositorty usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/generateToken")
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody User user) {
        System.out.printf(user.getEmail() + " " + user.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );

            if (authentication.isAuthenticated()) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                String token = jwtService.generateToken(userDetails.getUsername()); // Obtener el email del principal autenticado
                user.setToken(token);
                usuarioRepository.save(user);
                Map<String, String> response = new HashMap<>();
                response.put("message", "Token generado correctamente");
                response.put("token", token);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user.getEmail()+" "+user.getPassword());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user.getEmail()+" "+user.getPassword());
        }
    }

}
