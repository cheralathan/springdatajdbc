package com.endurance.datajdbc.jdbc.Customer;

import org.springframework.data.annotation.Id;

public class Customer {
    private final @Id Long id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public static Customer of(String firstName, String lastName, String email) {
        return new Customer(null, firstName, lastName, email);
    }

    public Customer(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Customer withId(Long id) {
        return new Customer(id, this.firstName, this.lastName, this.email);
    }

    public Long getId() {
        return id;
    }
}
