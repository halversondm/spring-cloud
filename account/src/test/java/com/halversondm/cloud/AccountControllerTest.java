// File: inactive/spring-cloud/account/src/test/java/com/halversondm/cloud/AccountControllerTest.java
package com.halversondm.cloud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AccountControllerTest {

    private MockMvc mockMvc;
    private AccountDao accountDao;

    List<Account> accounts;

    @BeforeEach
    void setUp() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1, "1", "111111", 1111.11));
        accounts.add(new Account(2, "2", "222222", 2222.22));
        accounts.add(new Account(3, "3", "333333", 3333.33));
        accounts.add(new Account(4, "4", "444444", 4444.44));
        accounts.add(new Account(5, "1", "555555", 5555.55));
        accounts.add(new Account(6, "2", "666666", 6666.66));
        accounts.add(new Account(7, "2", "777777", 7777.77));
        accountDao = Mockito.mock(AccountDao.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(accountDao)).build();
    }

    @Test
    void testFindAll() throws Exception {
        when(accountDao.findAll()).thenReturn(accounts);
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(7));
    }

    @Test
    void testFindByNumber() throws Exception {
        when(accountDao.findByNumber("111111")).thenReturn(accounts.get(0));
        mockMvc.perform(get("/accounts/111111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value("111111"));
    }

    @Test
    void testFindByCustomer() throws Exception {
        when(accountDao.findByCustomerId("2")).thenReturn(
                accounts.stream().filter(account -> account.getCustomerId().equals("2")).toList());
        mockMvc.perform(get("/accounts/customer/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }
}