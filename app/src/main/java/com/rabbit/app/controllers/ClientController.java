package com.rabbit.app.controllers;

import com.rabbit.app.repositories.ClientRepository;
import com.rabbit.app.models.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

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
}
