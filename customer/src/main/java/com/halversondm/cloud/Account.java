package com.halversondm.cloud;

import lombok.Data;

@Data
public class Account {

    private Integer id;
    private Integer customerId;
    private String number;

    public Account() {

    }

    public Account(Integer id, Integer customerId, String number) {
        this.id = id;
        this.customerId = customerId;
        this.number = number;
    }
}
