package com.testDB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testDB.entities.Customer;
import com.testDB.service.CustomerService;

@Controller()
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Get the customer from the Customer services
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Add customer to the model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}//Close listCustomers method.
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//Add Customer objet to theModel
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		
		return "customer-form";
		
	}//Close shhowFormForAdd method.
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		//Saving Customer
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
		
	}//Close saveCustomer method.
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model theModel) {

		//Get the costumer from our services
		Customer theCustomer = customerService.getCustomer(id);
		
		//Set theCustomer to the model.
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
	}//CLlose showFormForUpdate.
	
}//Close CustomerController class.
