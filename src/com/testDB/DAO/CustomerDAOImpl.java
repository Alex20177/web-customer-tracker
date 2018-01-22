package com.testDB.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.testDB.entities.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {

		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name",Customer.class);
		
		//Execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		return customers;

	}//Close getCustomer method.

	@Override
	public void saveCustomer(Customer customer) {

		//Get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Saving customer
		currentSession.save(customer);
		
	}//Close saveCustomer method.

	@Override
	public Customer getCustomer(int id) {
		
		//Get current hibernet session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Read the customer from data base using primary key
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

}//Close CustomerDAOImpl class.
