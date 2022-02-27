package com.sampleprojects.r2dbc.customerservice.customerservice.api.server.Controller;

import com.sampleprojects.r2dbc.customerservice.customerservice.entity.Customer;
import com.sampleprojects.r2dbc.customerservice.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/customers"))
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService service;

  @GetMapping
  public Publisher<Customer> getAllCustomers() {
    return service.getAllCustomers();
  }
}
