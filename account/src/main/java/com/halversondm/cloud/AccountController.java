package com.halversondm.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountApplication.class);

    private AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @RequestMapping("/accounts/{number}")
    public Account findByNumber(@PathVariable("number") String number) {
        logger.info(String.format("Account.findByNumber(%s)", number));
        return accountDao.findByNumber(number);
    }

    @RequestMapping("/accounts/customer/{customer}")
    public List<Account> findByCustomer(@PathVariable("customer") String customerId) {
        logger.info(String.format("Account.findByCustomer(%s)", customerId));
        return accountDao.findByCustomerId(customerId);
    }

    @RequestMapping("/accounts")
    public List<Account> findAll() {
        logger.info("Account.findAll()");
        return (List) accountDao.findAll();
    }
}
