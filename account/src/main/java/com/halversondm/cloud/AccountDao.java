package com.halversondm.cloud;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountDao extends CrudRepository<Account, Integer> {

    Account findByNumber(String number);

    List<Account> findByCustomerId(String customerId);
}
