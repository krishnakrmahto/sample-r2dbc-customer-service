package com.sampleprojects.r2dbc.customerservice.customerservice.service;

import com.sampleprojects.r2dbc.customerservice.customerservice.entity.Customer;
import com.sampleprojects.r2dbc.customerservice.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;

  public Publisher<Customer> getAllCustomers() {
    return repository.findAll();
  }

}
