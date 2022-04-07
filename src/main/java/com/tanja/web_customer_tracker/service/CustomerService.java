package com.tanja.web_customer_tracker.service;

import java.util.List;

import com.tanja.web_customer_tracker.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(int id);
	
	public void addCustomer(Customer c);
	
	public void deleteCustomer(int customerId);

}
