package com.tanja.web_customer_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanja.web_customer_tracker.DAO.CustomerDAO;
import com.tanja.web_customer_tracker.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer c) {
		customerDAO.saveCustomer(c);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		
		Customer customer = customerDAO.getCustomer(id);
		
		return customer;
	}
}
