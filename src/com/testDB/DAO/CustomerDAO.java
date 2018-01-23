package com.testDB.DAO;

import java.util.List;
import com.testDB.entities.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
	
}//Close CustomerDAO interface.
