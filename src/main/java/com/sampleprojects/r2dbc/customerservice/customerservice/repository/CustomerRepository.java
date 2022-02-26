package com.sampleprojects.r2dbc.customerservice.customerservice.repository;

import com.sampleprojects.r2dbc.customerservice.customerservice.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
}
