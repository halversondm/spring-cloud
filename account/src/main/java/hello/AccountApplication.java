package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class AccountApplication {

    private List<Account> accounts;

    protected Logger logger = LoggerFactory.getLogger(AccountApplication.class);

    public AccountApplication() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1, 1, "111111"));
        accounts.add(new Account(2, 2, "222222"));
        accounts.add(new Account(3, 3, "333333"));
        accounts.add(new Account(4, 4, "444444"));
        accounts.add(new Account(5, 1, "555555"));
        accounts.add(new Account(6, 2, "666666"));
        accounts.add(new Account(7, 2, "777777"));
    }

    @RequestMapping("/accounts/{number}")
    public Account findByNumber(@PathVariable("number") String number) {
        logger.info(String.format("Account.findByNumber(%s)", number));
        return accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
    }

    @RequestMapping("/accounts/customer/{customer}")
    public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
        logger.info(String.format("Account.findByCustomer(%s)", customerId));
        return accounts.stream().filter(it -> it.getCustomerId().intValue() == customerId.intValue()).collect(Collectors.toList());
    }

    @RequestMapping("/accounts")
    public List<Account> findAll() {
        logger.info("Account.findAll()");
        return accounts;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
