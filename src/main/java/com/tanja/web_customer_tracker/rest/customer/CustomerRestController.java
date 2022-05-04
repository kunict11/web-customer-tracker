package com.tanja.web_customer_tracker.rest.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanja.web_customer_tracker.model.customer.Customer;
import com.tanja.web_customer_tracker.service.customer.CustomerService;

@RestController
@CrossOrigin
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
		
		Customer customer = customerService.getCustomerById(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer wid id " + id + " doesn't exist");
		}
		
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		customer.setId(0);	
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
		
		if (customerService.getCustomerById(id) == null) {
			throw new CustomerNotFoundException("Unable to delete: No customer found with id " + id);
		}
		
		customerService.deleteCustomer(id);
		
		return "Successfully deleted customer";
	}

}
