package com.halversondm.cloud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CustomerControllerTest {

    private MockMvc mockMvc;
    private AccountClient accountClient;
    private CustomerDao customerDao;
    private List<Customer> customers;

    @BeforeEach
    void setUp() {
        accountClient = Mockito.mock(AccountClient.class);
        customerDao = Mockito.mock(CustomerDao.class);
        CustomerController controller = new CustomerController(accountClient, customerDao);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        customers = new ArrayList<>();
        customers.add(new Customer(1, "12345", "Steve Sanders", CustomerType.INDIVIDUAL));
        customers.add(new Customer(2, "12346", "Monica Lewinsky", CustomerType.INDIVIDUAL));
        customers.add(new Customer(3, "12347", "Bill Clinton", CustomerType.INDIVIDUAL));
        customers.add(new Customer(4, "12348", "Heidi Fleiss", CustomerType.INDIVIDUAL));
    }

    @Test
    void testFindAll() throws Exception {
        when(customerDao.findAll()).thenReturn(customers);
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    void testFindByPesel() throws Exception {
        when(customerDao.findByCustomerId("12345"))
                .thenReturn(new Customer(1, "12345", "Steve Sanders", CustomerType.INDIVIDUAL));
        mockMvc.perform(get("/customers/pesel/12345"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Steve Sanders"));
    }

}