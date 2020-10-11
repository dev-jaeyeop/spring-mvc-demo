package com.spring.mvc.service;

import com.spring.mvc.entity.Customer;
import com.spring.mvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Transactional
    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.getCustomer(customerId);
    }

    @Transactional
    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteCustomer(customerId);
    }

}
