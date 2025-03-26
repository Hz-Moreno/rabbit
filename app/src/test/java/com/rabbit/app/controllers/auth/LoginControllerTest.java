package com.rabbit.app.controllers.auth;

import com.rabbit.app.models.Client;
import com.rabbit.app.repositories.ClientRepository;
import com.rabbit.app.services.Password;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClientRepository clientRepository;

    @MockitoBean
    private Password passwordService;

    @Test
    public void testLoginSuccessWith200() throws Exception{
        Client mockClient = new Client();
        mockClient.setEmail("root@example.com");
        mockClient.setPassword("$2a$10$yH1JgLB3/t3hmeubaVx1ruZxdHowbyzwmV.ICTL1MXhIsaEYKTZ6.");

        when(clientRepository.findByEmail("root@example.com")).thenReturn(mockClient);
        when(passwordService.match("root", "$2a$10$yH1JgLB3/t3hmeubaVx1ruZxdHowbyzwmV.ICTL1MXhIsaEYKTZ6.")).thenReturn(true);

        String loginJson = "{\"email\": \"root@example.com\", \"password\": \"root\"}";
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson))
                .andExpect(status().isOk());

    }
}
