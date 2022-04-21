package com.tanja.web_customer_tracker.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanja.web_customer_tracker.model.Customer;
import com.tanja.web_customer_tracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String showCustomerList(Model model) {

		List<Customer> customers = customerService.getAllCustomers();
		
		model.addAttribute("customers", customers);
		
		return "customer-list";
	}
	
	@RequestMapping("/customerForm")
	public String showForm(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "add-customer";
	}
	
	@RequestMapping("/addCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer) {
		System.out.println(theCustomer);
		
		customerService.addCustomer(theCustomer);
		
		return "redirect:/customer/list";
			
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		
		return "add-customer";
	}
	
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/details")
	public String showCustomerDetails(@RequestParam("customerId") int id, Model model) {
		
		Customer customer = customerService.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		model.addAttribute("customerBirthday", customer.getCustomerDetails().getBirthdayString());
		
		if(customer.getCustomerDetails().getProfilePicture() != null) {
			String photo = Base64.getEncoder().encodeToString(customer.getCustomerDetails().getProfilePicture());
			model.addAttribute("customerPhoto", photo);
		}
		
		return "customer-details";
	}
}
