package com.rabbit.app.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encrypt(String password){
        return encoder.encode(password);
    }

    public static boolean match(String rawPassword, String encodedPassword){
        return encoder.matches(rawPassword, encodedPassword);
    }

}
