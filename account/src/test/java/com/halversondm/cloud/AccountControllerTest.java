package com.halversondm.cloud;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountControllerTest {

    private AccountController controller;

    @Before
    public void setUp() {
        controller = new AccountController();
    }

    @Test
    public void testFindByNumber_existing() {
        Account account = controller.findByNumber("111111");
        assertNotNull(account);
        assertEquals("111111", account.getNumber());
    }

    @Test
    public void testFindByCustomer_existing() {
        List<Account> accounts = controller.findByCustomer(2);
        assertEquals(3, accounts.size());
        assertTrue(accounts.stream().allMatch(a -> a.getCustomerId() == 2));
    }

    @Test
    public void testFindByCustomer_nonExisting() {
        List<Account> accounts = controller.findByCustomer(99);
        assertTrue(accounts.isEmpty());
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = controller.findAll();
        assertEquals(7, accounts.size());
    }
}