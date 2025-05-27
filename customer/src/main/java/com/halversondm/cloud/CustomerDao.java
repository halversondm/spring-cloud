package com.halversondm.cloud;

import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {

    Customer findByCustomerId(String customerId);
}
