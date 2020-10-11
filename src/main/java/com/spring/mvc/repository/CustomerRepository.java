package com.spring.mvc.repository;

import com.spring.mvc.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(Long customerId);

    void deleteCustomer(Long customerId);
}
