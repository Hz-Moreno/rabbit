package com.rabbit.app.service;

import com.rabbit.app.model.User;
import com.rabbit.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public boolean registerUser(String name, String email, String password){
        if(userRepository.findByEmail(email) != null ){
            return false;
        }
        String passwordEncoded = passwordEncoder.encode(password);

        User user = new User();
        user.setName(name);
        user.setPassword(passwordEncoded);
        user.setEmail(email);

        userRepository.save(user);

        return false;
    }
}
