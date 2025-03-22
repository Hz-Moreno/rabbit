package com.rabbit.app.models;

import com.rabbit.app.interfaces.User;
import jakarta.persistence.*;
import com.rabbit.app.services.Password;

import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client implements User {
    private String name;
    private String email;
    private String password;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    public Client() {};

    public Client(String email, String password, String name){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public UUID getId(){
        return id;
    }
    @Override
    public void setId(UUID id){
        this.id = id;
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getEmail(){
        return email;
    }
    @Override
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public void setPassword(String password){
       this.password = password;
    }

}
