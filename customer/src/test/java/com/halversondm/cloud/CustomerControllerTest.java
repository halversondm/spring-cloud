package com.halversondm.cloud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CustomerControllerTest {

    private MockMvc mockMvc;
    private AccountClient accountClient;

    @BeforeEach
    void setUp() {
        accountClient = Mockito.mock(AccountClient.class);
        CustomerController controller = new CustomerController(accountClient);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testFindAll() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    void testFindByPesel() throws Exception {
        mockMvc.perform(get("/customers/pesel/12345"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Steve Sanders"));
    }

    @Test
    void testFindById() throws Exception {
        Mockito.when(accountClient.getAccounts(anyInt()))
                .thenReturn(Collections.singletonList(new Account()));
        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Steve Sanders"))
                .andExpect(jsonPath("$.accounts.length()").value(1));
    }
}