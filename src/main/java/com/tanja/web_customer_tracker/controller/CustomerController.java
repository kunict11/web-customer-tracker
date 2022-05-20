package com.tanja.web_customer_tracker.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.tanja.web_customer_tracker.model.customer.Customer;
import com.tanja.web_customer_tracker.service.customer.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.initDirectFieldAccess();

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
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
	
	@RequestMapping(path = "/addCustomer", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer, @RequestPart("photo") MultipartFile photo) {
        System.out.println("customer "+ theCustomer);
        System.out.println("details " + theCustomer.getCustomerDetails());
        System.out.println("photo " + photo);
        try {
			theCustomer.getCustomerDetails().setProfilePicture(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
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
