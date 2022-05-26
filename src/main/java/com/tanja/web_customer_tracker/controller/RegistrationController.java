package com.tanja.web_customer_tracker.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.tanja.web_customer_tracker.model.Role;
import com.tanja.web_customer_tracker.model.customer.Customer;
import com.tanja.web_customer_tracker.service.RoleService;
import com.tanja.web_customer_tracker.service.customer.CustomerService;

@Controller
public class RegistrationController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleService roleService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.initDirectFieldAccess();

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/register")
	public String showRegistrationForm(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-registration";
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
        
        System.out.println(theCustomer.getPassword());
        String encodedPassword = passwordEncoder.encode(theCustomer.getPassword()).trim();
        System.out.println(encodedPassword.toString());
        
        theCustomer.setPassword(encodedPassword);
        theCustomer.setEmail(theCustomer.getEmail().trim());
        Role role = roleService.findRoleByName("ROLE_CUSTOMER");
        System.out.println(role);
        theCustomer.setRoles(Arrays.asList(role));
        
		customerService.addCustomer(theCustomer);
		
		return "redirect:/login";
			
	}
}
