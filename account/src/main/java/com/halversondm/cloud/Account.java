package com.halversondm.cloud;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
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
