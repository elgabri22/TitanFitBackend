package com.titanfit.TitanFit.service;

import com.titanfit.TitanFit.model.User;
import com.titanfit.TitanFit.repository.UserRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserRepositorty usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public String addUser(User usuario){
        System.out.println(usuario.getPassword());
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        System.out.println(usuario.getPassword());
        usuarioRepository.save(usuario);
        return "Usuario registrado correctamente";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = usuarioRepository.findByEmail(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

    }
}
