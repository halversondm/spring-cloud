package com.halversondm.cloud;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    private Integer id;
    private String customerId;
    private String name;
    private CustomerType type;
    @Transient
    private List<Account> accounts;

    public Customer() {

    }

    public Customer(Integer id, String customerId, String name, CustomerType type) {
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.type = type;
    }

}
