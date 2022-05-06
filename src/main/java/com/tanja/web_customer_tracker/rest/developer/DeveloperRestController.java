package com.tanja.web_customer_tracker.rest.developer;

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

import com.tanja.web_customer_tracker.model.developer.Developer;
import com.tanja.web_customer_tracker.service.developer.DeveloperService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DeveloperRestController {

	@Autowired
	private DeveloperService developerService;
	
	@GetMapping("/developers")
	public List<Developer> getAllDevelopers() {
		return developerService.getAllDevelopers();
	}
	
	@GetMapping("/developers/{id}")
	public Developer getDeveloperById(@PathVariable int id) {
		
		Developer developer = developerService.getDeveloperById(id);
		
		if (developer == null) {
			throw new DeveloperNotFoundException("Developer wid id " + id + " doesn't exist");
		}
		
		return developer;
	}
	
	@PostMapping("/developers")
	public Developer addDeveloper(@RequestBody Developer developer) {
		
		developer.setId(0);	
		developerService.saveDeveloper(developer);
		
		return developer;
	}
	
	@PutMapping("/developers")
	public Developer updateDeveloper(@RequestBody Developer updatedDeveloper) {
		
		developerService.saveDeveloper(updatedDeveloper);
		
		return updatedDeveloper;		
	}
	
	@DeleteMapping("/developers/{id}")
	public String deleteDeveloper(@PathVariable int id) {
		
		if (developerService.getDeveloperById(id) == null) {
			throw new DeveloperNotFoundException("Unable to delete: No developer found with id " + id);
		}
		
		developerService.deleteDeveloperById(id);
		
		return "Successfully deleted developer";
	}
	
}
