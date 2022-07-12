package com.example.jwtproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class AuthTest {

    @Autowired
    MockMvc MockMvc;

    @Test
    @WithMockUser(authorities = "ROLE_ADMIN")
    public void test1() throws Exception {
        MockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(authorities = "ROLE_USER")
    public void test2() throws Exception {
        MockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isForbidden());
    }
}
