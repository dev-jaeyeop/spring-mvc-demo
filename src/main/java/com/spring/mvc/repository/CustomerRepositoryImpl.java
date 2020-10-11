package com.spring.mvc.repository;

import com.spring.mvc.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> from_customer = currentSession.createQuery("from Customer order by lastName", Customer.class);

        return from_customer.getResultList();
    }

    @Override
    public Customer getCustomer(Long customerId) {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", customerId);
        query.executeUpdate();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

}
