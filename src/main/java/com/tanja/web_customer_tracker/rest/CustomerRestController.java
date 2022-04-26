package com.tanja.web_customer_tracker.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanja.web_customer_tracker.model.Customer;
import com.tanja.web_customer_tracker.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getAllCustomers(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		customerService.addCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
		
		customerService.addCustomer(updatedCustomer);
		
		return updatedCustomer;		
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		
		return "Successfully deleted customer";
	}

}
