package com.spring.mvc.service;

import com.spring.mvc.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(Long customerId);

    void deleteCustomer(Long customerId);

}
