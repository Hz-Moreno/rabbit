package com.rabbit.app.controllers;

import com.rabbit.app.repositories.ClientRepository;
import com.rabbit.app.models.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping("/")
    public List<Client> get(){
        return clientRepository.findAll();
    }

    @PostMapping("/create")
    public Client create(@RequestBody Client data){
        Client client = new Client();
        client.setName(data.getName());
        client.setEmail(data.getEmail());
        client.setPassword(data.getPassword());

        return clientRepository.save(client);
    }
}
