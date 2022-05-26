package com.tanja.web_customer_tracker.service.customer;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanja.web_customer_tracker.DAO.customer.CustomerDAO;
import com.tanja.web_customer_tracker.DAO.role.RoleDAO;
import com.tanja.web_customer_tracker.model.customer.Customer;

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

	@Override
	@Transactional
	public Customer getCustomerByEmail(String email) {
		return customerDAO.findByEmail(email);
	}
	
	
}
