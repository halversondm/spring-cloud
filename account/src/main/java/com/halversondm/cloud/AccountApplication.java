package com.halversondm.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AccountApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
