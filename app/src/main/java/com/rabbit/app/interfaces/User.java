package com.rabbit.app.interfaces;

import java.util.UUID;

public interface User {
    UUID getId();
    String getName();
    String getPassword();
    String getEmail();

    void setId(UUID id);
    void setName(String name);
    void setPassword(String password);
    void setEmail(String email);

}
