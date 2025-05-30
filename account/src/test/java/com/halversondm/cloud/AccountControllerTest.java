package com.halversondm.cloud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class AccountControllerTest {

    private AccountController controller;

    @BeforeEach
    public void setUp() {
        controller = new AccountController();
    }

    @Test
    public void testFindByNumber_existing() {
        Account account = controller.findByNumber("111111");
        Assertions.assertNotNull(account);
        Assertions.assertEquals("111111", account.getNumber());
    }

    @Test
    public void testFindByCustomer_existing() {
        List<Account> accounts = controller.findByCustomer(2);
        Assertions.assertEquals(3, accounts.size());
        Assertions.assertTrue(accounts.stream().allMatch(a -> a.getCustomerId() == 2));
    }

    @Test
    public void testFindByCustomer_nonExisting() {
        List<Account> accounts = controller.findByCustomer(99);
        Assertions.assertTrue(accounts.isEmpty());
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = controller.findAll();
        Assertions.assertEquals(7, accounts.size());
    }
}