package com.sampleprojects.r2dbc.customerservice.customerservice.service;

import com.sampleprojects.r2dbc.customerservice.customerservice.util.demo.DatabaseSampleInitializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CustomerServiceTest {

  @Autowired
  private CustomerService customerService;

  @Autowired
  private DatabaseSampleInitializer databaseSampleInitializer;

  @Test
  void getAllCustomersSubscribe_afterRunningInitSampleDatabase_logsSuccessfully() {

    databaseSampleInitializer.initializeDatabaseWithSampleValues()
        .thenMany(customerService.getAllCustomers())
        .subscribe(customer -> log.info("Customer: {}", customer));
  }


}