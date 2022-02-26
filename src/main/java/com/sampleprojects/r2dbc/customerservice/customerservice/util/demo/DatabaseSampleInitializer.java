package com.sampleprojects.r2dbc.customerservice.customerservice.util.demo;

import com.sampleprojects.r2dbc.customerservice.customerservice.entity.Customer;
import com.sampleprojects.r2dbc.customerservice.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class DatabaseSampleInitializer {

  private final DatabaseClient databaseClient;
  private final CustomerRepository repository;

  public void initializeDatabaseWithSampleValues() {

//    Flux<String> customerNames = Flux.just("Dhanya ji", "Prashant", "Dhawal", "Hardik", "Vinay", "Pranav", "Madhurjya");
//    Flux<Customer> customers = customerNames.map(name -> Customer.builder().name(name).build());
//    Flux<Customer> savedCustomers = customers.flatMap(repository::save);
//    savedCustomers.subscribe(savedCustomer -> log.info(String.valueOf(savedCustomer)));

//    All of the above can be condensed as follows:

    Mono<Integer> ddlCreate = databaseClient.sql("create table customer (id serial primary key, name varchar(255) not null)")
        .fetch()
        .rowsUpdated();

    Flux<Customer> savedCustomers = Flux.just("Dhanya ji", "Prashant", "Dhawal", "Hardik", "Vinay", "Pranav", "Madhurjya")
        .map(name -> Customer.builder().name(name).build())
        .flatMap(repository::save);

    ddlCreate.thenMany(savedCustomers)
        .subscribe(customer -> log.info(String.valueOf(customer)));
  }
}
