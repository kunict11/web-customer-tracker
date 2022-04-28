package com.tanja.web_customer_tracker.service.customer;

import java.util.List;

import com.tanja.web_customer_tracker.model.customer.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(int id);
	
	public void addCustomer(Customer c);
	
	public void deleteCustomer(int customerId);

}
