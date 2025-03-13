package com.rabbit.app.model;

import com.rabbit.app.service.Authenticable;

import java.util.List;
import javax.persistence.*;

@Entity
public class User extends Authenticable {
    private String name;
    private String email;
    private String password;

    @Id
    @GeneratedValue(stategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public List<Task> getTask(){
        return tasks;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
