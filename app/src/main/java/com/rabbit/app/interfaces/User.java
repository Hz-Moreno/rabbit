package com.rabbit.app.interfaces;

public interface User {
    Long getId();
    String getName();
    String getPassword();
    String getEmail();

    void setId(Long id);
    void setName(String name);
    void setPassword(String password);
    void setEmail(String email);

    void login(String email, String password);
    void register();
    void logout();
}
