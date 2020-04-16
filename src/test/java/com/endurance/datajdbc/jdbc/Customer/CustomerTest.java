package com.endurance.datajdbc.jdbc.Customer;

import com.endurance.datajdbc.repository.Customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
class CustomerTest {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerTest(CustomerRepository repository) {
            customerRepository = repository;
    }

    @Test
    public void NewCustomer() {
        Customer customer = Customer.of("John", "Sullivan", "jsully55@gmail.com");
        Customer persistedCustomer = customerRepository.save(customer);
        assertNotNull(persistedCustomer.getId(), ()-> "New customer not created.");
    }

    @Test
    public void deleteCustomer() {
        Customer customer = Customer.of("John", "Sullivan", "jsully55@gmail.com");
        Customer persistedCustomer = customerRepository.save(customer);
        customerRepository.deleteById(persistedCustomer.getId());
        final Optional<Customer> customerById = customerRepository.findById(persistedCustomer.getId());
        assertTrue(customerById.isEmpty(), ()->"Failed to delete customer");
    }

}