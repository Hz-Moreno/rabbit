package com.rabbit.app.services;

import java.util.Date;
import java.util.UUID;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWT {
    private static final String SECRET_KEY = "uhudqbediquh92gh279guid2udbiqebd97g278g4d2ib34d";
    private static final long EXPIRATION_TIME = 21600000; // 6 HOURS

    public static String create(String role, UUID id, Long expiration_time){
        return Jwts.builder()
                .setSubject(id.toString())
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration_time))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}
