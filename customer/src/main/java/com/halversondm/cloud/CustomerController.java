package com.halversondm.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private List<Customer> customers;

    AccountClient accountClient;

    public CustomerController(AccountClient accountClient) {
        this.accountClient = accountClient;
        customers = new ArrayList<>();
        customers.add(new Customer(1, "12345", "Steve Sanders", CustomerType.INDIVIDUAL));
        customers.add(new Customer(2, "12346", "Monica Lewinsky", CustomerType.INDIVIDUAL));
        customers.add(new Customer(3, "12347", "Bill Clinton", CustomerType.INDIVIDUAL));
        customers.add(new Customer(4, "12348", "Heidi Fleiss", CustomerType.INDIVIDUAL));
    }


    @RequestMapping("/customers/pesel/{pesel}")
    public Customer findByPesel(@PathVariable("pesel") String pesel) {
        logger.info(String.format("Customer.findByPesel(%s)", pesel));
        return customers.stream().filter(it -> it.getCustomerId().equals(pesel)).findFirst().get();
    }

    @RequestMapping("/customers")
    public List<Customer> findAll() {
        logger.info("Customer.findAll()");
        return customers;
    }

    @RequestMapping("/customers/{id}")
    public Customer findById(@PathVariable("id") Integer id) {
        logger.info(String.format("Customer.findById(%s)", id));
        Customer customer = customers.stream().filter(it -> it.getId().intValue() == id.intValue()).findFirst().get();
        List<Account> accounts = accountClient.getAccounts(id);
        customer.setAccounts(accounts);
        return customer;
    }
}
