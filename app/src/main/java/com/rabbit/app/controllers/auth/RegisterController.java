package com.rabbit.app.controllers.auth;

import com.rabbit.app.dto.RegisterRequest;
import com.rabbit.app.models.Client;
import com.rabbit.app.repositories.ClientRepository;
import com.rabbit.app.services.Password;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/register")
public class RegisterController {
    private final ClientRepository clientRepository;

    public RegisterController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @PostMapping()
    public Client create(@RequestBody RegisterRequest registerRequest){
        Client client = new Client();
        client.setName(registerRequest.getName());
        client.setEmail(registerRequest.getEmail());
        client.setPassword(Password.encrypt(registerRequest.getPassword()));

        return clientRepository.save(client);
    }
}
