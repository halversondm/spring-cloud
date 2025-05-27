package com.halversondm.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    AccountClient accountClient;

    CustomerDao customerDao;

    public CustomerController(AccountClient accountClient, CustomerDao customerDao) {
        this.accountClient = accountClient;
        this.customerDao = customerDao;
    }


    @RequestMapping("/customers/pesel/{pesel}")
    public Customer findByPesel(@PathVariable("pesel") String pesel) {
        logger.info(String.format("Customer.findByPesel(%s)", pesel));
        Customer customer = customerDao.findByCustomerId(pesel);
        List<Account> accounts = accountClient.getAccounts(customer.getId());
        customer.setAccounts(accounts);
        return customer;
    }

    @RequestMapping("/customers")
    public List<Customer> findAll() {
        logger.info("Customer.findAll()");
        return (List<Customer>) customerDao.findAll();
    }

}
