package com.endurance.datajdbc.repository.Customer;

import com.endurance.datajdbc.jdbc.Customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
