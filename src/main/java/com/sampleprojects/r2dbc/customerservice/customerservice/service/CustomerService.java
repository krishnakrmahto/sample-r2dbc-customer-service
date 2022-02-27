package com.sampleprojects.r2dbc.customerservice.customerservice.service;

import com.sampleprojects.r2dbc.customerservice.customerservice.entity.Customer;
import com.sampleprojects.r2dbc.customerservice.customerservice.repository.CustomerRepository;
import com.sampleprojects.r2dbc.customerservice.customerservice.util.demo.DatabaseSampleInitializer;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;
  private final DatabaseSampleInitializer dataInitializer;

  public Publisher<Customer> getAllCustomers() {
    return dataInitializer.initializeDatabaseWithSampleValues()
        .thenMany(repository.findAll())
        .delayElements(Duration.ofSeconds(2));
  }

}
