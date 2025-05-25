package com.halversondm.cloud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class BookControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
    }

    @Test
    void testAvailable() throws Exception {
        mockMvc.perform(get("/available"))
                .andExpect(status().isOk())
                .andExpect(content().string("Spring in action"));
    }

    @Test
    void testCheckedOut() throws Exception {
        mockMvc.perform(get("/checked-out"))
                .andExpect(status().isOk())
                .andExpect(content().string("Spring Boot in Action"));
    }
}