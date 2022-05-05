package com.tanja.web_customer_tracker.rest.bug;

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

import com.tanja.web_customer_tracker.model.bug.Bug;
import com.tanja.web_customer_tracker.model.customer.Customer;
import com.tanja.web_customer_tracker.model.project.Project;
import com.tanja.web_customer_tracker.service.bug.BugService;
import com.tanja.web_customer_tracker.service.customer.CustomerService;
import com.tanja.web_customer_tracker.service.project.ProjectService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BugRestController {

	@Autowired
	private BugService bugService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/bugs")
	public List<Bug> getAllBugs() {
		return bugService.getAllBugs();
	}
	
	@GetMapping("/bugs/{id}")
	public Bug getBugById(@PathVariable("id") int id) {
		
		Bug bug = bugService.getBugById(id);
		
		if (bug == null) {
			throw new BugNotFoundException("Bug with id " + id + " doesn't exist");
		}
		
		return bug;
	}
	
	@PostMapping("/bugs")
	public Bug addBug(@RequestBody Bug bug) {
		
		bug.setId(0);
		
		Customer customer = customerService.getCustomerByEmail(bug.getCustomer().getEmail());
		customer.reportBug(bug);
		
		bugService.saveBug(bug);
		
		return bug;
	}
	
	@DeleteMapping("/bugs/{id}")
	public String deleteBug(@PathVariable("id") int id) {
		
		Bug bug = bugService.getBugById(id);
		
		if (bug == null) {
			throw new BugNotFoundException("Unable to delete: Bug with id " + id + " doesn't exist.");
		}
		
		bugService.deleteBug(id);
		
		return "Bug successfully deleted";
	}
	
}
