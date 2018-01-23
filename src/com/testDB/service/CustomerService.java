package com.testDB.service;

import java.util.List;
import com.testDB.entities.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
	
}//Close CustomerService
