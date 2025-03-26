package com.rabbit.app.controllers.auth;

import com.rabbit.app.dto.LoginRequest;
import com.rabbit.app.models.Client;
import com.rabbit.app.repositories.ClientRepository;
import com.rabbit.app.services.JWT;
import com.rabbit.app.services.Password;
import com.rabbit.app.services.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/login")
public class LoginController {

    private final ClientRepository clientRepository;
    private final Password passwordService;
    private Session sessionService;

    public LoginController(ClientRepository clientRepository, Password passwordService){
        this.clientRepository = clientRepository;
        this.passwordService = passwordService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();
        try {
            Client client = clientRepository.findByEmail(loginRequest.getEmail());
            if (client != null && passwordService.match(loginRequest.getPassword(), client.getPassword())) {
                Session session =  new Session(client, "client");
                response.put("access_token", session.getToken());
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Invalid email or password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            response.put("error", "An error occurred during login " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
