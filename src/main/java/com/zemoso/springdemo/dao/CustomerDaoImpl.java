package com.zemoso.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zemoso.springdemo.entity.Customer;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDAO{

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomer() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create query
        Query<Customer> query = currentSession.createQuery("from Customer order by firstName",
                Customer.class);

        //execute the query
        List<Customer> customerList = query.getResultList();

        //return the results
        return customerList;
    }

    @Override
    public void saveCustomer(Customer customer) {

        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save/update the customer
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //now retrieve /read from database using the primary key
        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void deleteCustomer(int id) {

        //get the current session
        Session currentSession = sessionFactory.getCurrentSession();

        //retrieve the object from DB
        Customer customer = currentSession.get(Customer.class, id);

        //delete the object from database

        currentSession.delete(customer);
    }
}
