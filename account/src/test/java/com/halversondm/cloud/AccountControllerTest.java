// File: inactive/spring-cloud/account/src/test/java/com/halversondm/cloud/AccountControllerTest.java
package com.halversondm.cloud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AccountControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AccountController()).build();
    }

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(7));
    }

    @Test
    void testFindByNumber() throws Exception {
        mockMvc.perform(get("/accounts/111111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value("111111"));
    }

    @Test
    void testFindByCustomer() throws Exception {
        mockMvc.perform(get("/accounts/customer/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
}