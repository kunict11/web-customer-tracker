package com.tanja.web_customer_tracker.DAO.customer;

import java.util.List;

import com.tanja.web_customer_tracker.model.customer.Customer;


public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
	
	public void saveCustomer(Customer c);
	
	public void deleteCustomer(int customerId);
	
	public Customer findByEmail(String email);

}
