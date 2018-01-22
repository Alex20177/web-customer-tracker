package com.testDB.service;

import java.util.List;
import com.testDB.entities.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);
	
}//Close CustomerService
