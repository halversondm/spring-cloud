package com.halversondm.cloud;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    private Integer id;
    private String customerId;
    private Double amount;
    private String number;

    public Account() {

    }

    public Account(Integer id, String customerId, String number, Double amount) {
        this.id = id;
        this.customerId = customerId;
        this.number = number;
        this.amount = amount;
    }
}
