package com.halversondm.cloud;

import lombok.Data;

@Data
public class Account {

    private Integer id;
    private String customerId;
    private String number;
    private Double amount;

    public Account() {

    }

    public Account(Integer id, String customerId, String number, Double amount) {
        this.id = id;
        this.customerId = customerId;
        this.number = number;
        this.amount = amount;
    }
}
