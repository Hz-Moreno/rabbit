package com.rabbit.app.controllers.auth;


import com.rabbit.app.dto.LoginRequest;
import com.rabbit.app.models.Client;
import com.rabbit.app.repositories.ClientRepository;
import com.rabbit.app.services.JWT;
import com.rabbit.app.services.Password;
import com.rabbit.app.services.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    private final ClientRepository clientRepository;

    public LoginController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @PostMapping
    public Map<String, String> login(@RequestBody LoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();
        try {
            Client client = clientRepository.findByEmail(loginRequest.getEmail());
            if (client != null && Password.match(loginRequest.getPassword(), client.getPassword())) {
                Session session =  new Session(client, "client");
                response.put("access_token", session.getToken());
            } else {
                response.put("error", "Invalid email or password");
            }
        } catch (Exception e) {
            response.put("error", "An error occurred during login " + e.getMessage());
        }
        return response;
    }
}
