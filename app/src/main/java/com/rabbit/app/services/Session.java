package com.rabbit.app.services;

import com.rabbit.app.services.JWT;
import com.rabbit.app.models.Client;
import com.rabbit.app.interfaces.User;
import java.util.Date;

public class Session {
    private User user;
    private String token;
    private String type;
    private Date created_at;
    private final long EXPIRATION_TIME = 21600000;
    private boolean active;

    public Session(User user, String type){
        this.user = user;
        this.type = type;
        this.token = setToken(user, type);
        this.created_at = new Date();
        this.active = true;
    }

    public User getUser(){
        return this.user;
    }

    public String getToken(){
        return this.token;
    }
    private final String setToken(User user, String type){
        return JWT.create(type, user.getId(), EXPIRATION_TIME);
    }
}
