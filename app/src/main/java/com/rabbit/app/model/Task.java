package com.rabbit.app.model;

import javax.annotation.processing.Generated;
import jakarta.persistence.*;
import com.rabbit.app.model.User;

@Entity
public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private double duration;
    private String start_time;
    private String end_time;
    private String category;
    private User user;

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for duration
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }

    // Getter and Setter for start_time
    public String getStart_time() {
        return start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    // Getter and Setter for end_time
    public String getEnd_time() {
        return end_time;
    }
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and Setter for User
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}